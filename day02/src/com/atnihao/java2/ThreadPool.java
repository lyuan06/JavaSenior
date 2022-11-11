package com.atnihao.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
  提高响应速度（减少了创建新线程的时间）
  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
  便于线程管理
          corePoolSize：核心池的大小
          maximumPoolSize：最大线程数
          keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * @author nihao
 * @create 2022-11-07 14:46
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程chi池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(5);
//        service1.setKeepAliveTime(5);


     //2.执行指定的线程的操作。需要实现runnable或callable接口实现类的对象
        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());//适用于Runnable

//        service.submit();//适用于Callable

        //3.关闭线程池
        service.shutdown();
    }
}
