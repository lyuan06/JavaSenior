package com.atnihao.java;

/**
 * 多线程的创建：方式一：继承于thread类
 * 1.创建一个继承于thread类的子类
 * 2.重写thread类的run方法--->将此线程要做的操作声明在run方法中
 * 3.创建thread子类的对象
 * 4.通过此对象调用start方法
 *
 *
 * 例如：遍历100以内的所有偶数
 *
 * @author nihao
 * @create 2022-11-06 11:00
 */
//1.创建一个继承于thread类的子类
    class MyThread extends Thread{
    //2.重写run方法
    @Override
    public void run() {
        for(int i = 0;i < 100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}


public class ThreadTest {

    public static void main(String[] args) {
        //3.创建子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start方法：①启动当前线程②调用当前线程的run()
        t1.start();

        //问题1：我们不能通过直接调用run()的方式启动线程
//        t1.run();

        //问题2：再启动一个线程，遍历100以内的偶数。不可以让已经start()的线程去执行，会报错
//        t1.start();

        //我们需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();


        //用来测试多线程，一个线程是主线程的遍历，另一个线程是通过对象调用的线程
        for(int i = 0;i < 100;i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" +i + "*********");
            }
        }

    }
}
