package com.atnihao.java2;

/**
 * 线程通信例子；使用两个线程打印1-100。线程1，线程2 交替打印
 *
 * 涉及到的三个方法
 * wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器。意味着，其他线程就可以进入
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个
 * notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或者，同步方法中。
 * 2.这三个方法的调用者必须是同步代码块中的同步监视器。否则会出现IllegalMonitorStateException异常
 * 3.这三个方法定义在java.lang.Object类中
 *
 *
 * 面试题：sleep() 和 的异同？
 * 1.相同点：一旦执行这两个方法，都可以使得当前线程进入阻塞状态
 * 2.不同点：1）两个方法声明的位置不一样：thread类中声明sleep()，object类中声明wait()
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步方法和同步代码块中
 *          3）关于是否释放同步监视器：如果两个方法都使用在同步方法和同步代码块中，sleep()不会释放同步监视器
 *          wait()会释放同步监视器
 *
 *
 * @author nihao
 * @create 2022-11-07 10:53
 */
class Number implements Runnable{
    private int number = 1;

//    private Object object = new Object();

    @Override
    public void run() {

        while(true){

            synchronized (this){
                if(number <= 100){

                    this.notify();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }else{
                    break;
                }
            }

        }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}
