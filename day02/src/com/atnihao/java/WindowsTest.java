package com.atnihao.java;

/**
 *
 * 例子；创建三个窗口卖票，总票数是100张,使用继承thread类的方式
 * 存在线程的安全问题
 *
 *
 * @author nihao
 * @create 2022-11-06 15:23
 */

class Window extends Thread{

    private static int ticket = 100;


    @Override
    public void run() {

        while(true){
            if(ticket > 0){
                System.out.println(this.getName() + " : 卖号，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowsTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
