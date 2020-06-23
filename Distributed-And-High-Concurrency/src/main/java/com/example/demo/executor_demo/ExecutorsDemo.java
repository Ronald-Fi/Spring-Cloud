package com.example.demo.executor_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsDemo implements Runnable {

    static ExecutorService service = Executors.newFixedThreadPool(5);//不建议使用

    public static void main(String[] args) {
        /*for (int i = 0; i < 50; i++) {
            service.execute(new ExecutorsDemo());
        }*/
        //关闭线程
        service.shutdown();
        //当前线程立马终止  不建议使用
        service.shutdownNow();
        //回收核心线程
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        //线程预热、初始化核心线程
        executor.prestartAllCoreThreads();
        executor.prestartCoreThread();
        //不带返回值  会抛出异常
        service.execute(new ExecutorsDemo());//预热之后可以直接执行任务实例
        //场景 线程执行完毕响应  不会抛异常
//        service.submit();//带返回值的线程 Future.get获取

        executor.allowCoreThreadTimeOut(true);//核心线程回收策略
        //TODO 建议使用
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        //运行中设置核心线程数
        //executor.setCorePoolSize();
        //executor.setMaximumPoolSize();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
