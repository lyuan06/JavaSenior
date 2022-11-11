package com.atnihao.java;

/**
 * 例子；创建三个窗口卖票，总票数是100张,使用实现Runnable接口的方式
 * 存在线程安全问题
 *
 * @author nihao
 * @create 2022-11-06 16:02
 */

class Windows1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}

public class WindowsTest1 {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
