package com.example.demo.countDownLatch_demo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 extends Thread {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchDemo2().start();
            System.out.println("i=" + i);
        }
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
        System.out.println("主线程：=" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();//阻塞的是当前线程  不是主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO 业务逻辑
        System.out.println("ThreadName:=" + Thread.currentThread().getName());
    }
}
