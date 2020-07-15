package com.example.demo.executor_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class App implements Runnable {

    static ExecutorService service = Executors.newFixedThreadPool(5);//不建议使用

    @Override
    public void run() {//run执行完毕意味着线程被终止了、终止之后被JVM回收
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
                //发生异常将当前信息加入到Redis或者Es
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            service.execute(new App());
        }*/
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service;
        //线程预热、初始化核心线程
        threadPoolExecutor.prestartAllCoreThreads();
        //销毁回收核心线程
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        service.shutdown();
    }
}
