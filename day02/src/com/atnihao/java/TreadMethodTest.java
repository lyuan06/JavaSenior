package com.atnihao.java;

/**
 *
 * 测试thread中常用的方法
 * 1.start():启动当前线程；调用当前线程的run方法
 * 2.run():通常需要重写thread中此方法，将创建的线程执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权（切换线程，也有可能切换的线程还是当前线程）
 * 7.join()：在线程A中调用线程B的join方法，此时线程A就进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 * 8.stop():已过时。当执行此方法时，强制结束此进程
 * 9.sleep(long millitime)：让当前线程睡眠指定的Milltime毫秒。在指定时间内当前线程是阻塞状态。
 * 10.isAlive():判断当前线程是否还存活
 *
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY:10
 *   MIN_PRIORITY:1
 *   NORM_PRIORITY:5   默认优先级
 * 2.如何获取和设置当前线程的优先级
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率下被执行
 *        并不意味着只有当优先级的线程执行完以后，低优先级的线程才执行
 *
 *
 * @author nihao
 * @create 2022-11-06 13:16
 */

class HelloThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            if(i % 2 == 0){

//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() +   ": " + Thread.currentThread().getPriority() + ": " + i);
            }

//            if(i % 20 ==0){
//                yield();
//            }
        }
    }

    //通过构造器给线程命名
    public HelloThread(String name){
        super(name);

    }
}

public class TreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");

//        h1.setName("线程1");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");

        for(int i = 0;i < 100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority()+ ":" + i);
            }


//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

//        System.out.println(h1.isAlive());
    }
}
