package com.atnihao.java;

/**
 *
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到thread类的构造器中，创建thread类的对象
 * 5.通过thread类的对象调用start()方法
 *
 *
 * 比较创建线程的两种方式。
 * 开发中，有限选择实现runnable接口的方式
 * 原因1：实现的方式没有类的单继承的局限性
 *    2：实现的方式更适合处理多个线程具有共享的数据的情况
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run方法，将线程要执行的逻辑声明在run()中
 *
 *
 * @author nihao
 * @create 2022-11-06 15:42
 */

class Mthread implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":"+  i);
            }
            
        }
    }

}


public class ThreadTest1 {
    public static void main(String[] args) {
        Mthread mthread = new Mthread();

        Thread t1 = new Thread(mthread);

        t1.start();

        //再启动一个线程
        Thread t2 = new Thread(mthread);
        t2.start();
    }
}
