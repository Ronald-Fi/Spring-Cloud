package com.example.demo.countDownLatch_demo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println(countDownLatch.getCount());
        new Thread(()->{
            System.out.println("Thread 1");
            countDownLatch.countDown();// 3-1=2
            System.out.println(countDownLatch.getCount());
        }).start();
        new Thread(()->{
            System.out.println("Thread 1");
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount());
        }).start();
        new Thread(()->{
            System.out.println("Thread 1");
            countDownLatch.countDown();
            System.out.println(countDownLatch.getCount());
        }).start();
        countDownLatch.await();//主线程阻塞
    }
}
