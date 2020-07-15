package com.example.demo.executor_demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo extends ThreadPoolExecutor {

    public ThreadPoolDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                          BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        //get方法可以对当前线程池进行监控
        this.getPoolSize();//线程池大小
        this.getActiveCount();//正在执行的任务数量
        this.getCorePoolSize();//获得核心线程数
        this.getTaskCount();//任务总量
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    public static void main(String[] args) {

    }
}
