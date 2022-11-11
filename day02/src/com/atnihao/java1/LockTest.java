package com.atnihao.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题方式三：Lock锁---JDK5.0新增
 *
 * 1.面试题：synchronized 与 Lock的异同
 * 同：二者都可以解决线程安全问题
 * 异：synchronized机制，在执行完相应的同步代码之后，自动的释放同步监视器
 *    Lock需要手动的启动同步（lock()）,同时结束同步也需要手动实现（unlock()）
 *
 * 2.面试题：如何解决线程的安全问题？有几种方式？
 *
 *
 *
 *
 *
 * @author nihao
 * @create 2022-11-07 10:05
 */
class Window implements Runnable{

    private int ticket = 100;

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while(true){
            try{

                //2.调用锁定方法lock()
                lock.lock();

                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {

                //3.调用解锁的方法：unlock()
                lock.unlock();
            }

        }

    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}
