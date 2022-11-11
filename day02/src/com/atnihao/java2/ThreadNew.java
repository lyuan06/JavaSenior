package com.atnihao.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程的方式三：实现Callable接口。-----JDK5.0新增
 *
 *
 * 如何理解实现Callable接口的方式创建多线程比实现runnable接口创建多线程方式更强大
 * 1.call方法可以有返回值的
 * 2.call方法可以抛异常，被外面的操作捕获，获取异常信息
 * 3.Callable支持泛型的
 *
 *
 *
 * 步骤：
 * 1.创建实现Callable的实现类
 * 2.实现call方法，将此线程需要执行的操作声明在call方法中，可以有返回值
 * 3.创建Callable接口实现类的对象
 * 4.将Callable接口实现类的对象做为参数传递到FutureTask的构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
 *
 * 6.获取callable中的call方法的返回值
 *
 *
 *
 * @author nihao
 * @create 2022-11-07 14:10
 */
//1.创建实现Callable的实现类
class NumThread implements Callable{

    //2.实现call方法，将此线程需要执行的操作声明在call方法中，可以有返回值

    @Override
    public Object call() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }
}
public class ThreadNew {

    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //4.将Callable接口实现类的对象做为参数传递到FutureTask的构造器中，创建FutureTask的对象
        FutureTask future = new FutureTask(numThread);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()

        new Thread(future).start();

        //6.获取callable中的call方法的返回值

        try {
            Object sum = future.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
