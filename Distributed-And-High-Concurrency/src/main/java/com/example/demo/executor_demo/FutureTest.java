package com.example.demo.executor_demo;

import java.util.concurrent.*;

public class FutureTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("execute:--->Call");
        Thread.sleep(5000);
        return "Hello World Call";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTest futureTest = new FutureTest();
        FutureTask futureTask = new FutureTask<>(futureTest);
        new Thread(futureTask).start();
        //获取当前线程返回结果 该方法是阻塞的  必须线程执行完毕才能获得结果
        System.out.println(futureTask.get());
        //等同
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(futureTask);
        System.out.println(future.get());
    }
}
