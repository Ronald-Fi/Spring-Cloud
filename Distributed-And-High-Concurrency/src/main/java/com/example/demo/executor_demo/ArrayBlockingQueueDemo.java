package com.example.demo.executor_demo;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {

    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    {
        init();//构造块初始化
    }

    public void init() {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("take start");
                    String data = (String) arrayBlockingQueue.take();//阻塞获取
                    System.out.println("receive:" + data + "take end");
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "ThreadA").start();

        new Thread(() -> {
            while (true) {
                try {
                    arrayBlockingQueue.take();//阻塞获取
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "ThreadB").start();

        new Thread(() -> {
            while (true) {
                try {
                    arrayBlockingQueue.take();//阻塞获取
                    //task.run
                    /**
                     * task.run
                     * 不是启动当前线程
                     * 而是启动当前任务中的run方法
                     */
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "ThreadC").start();
    }

    public void sendData(String str) throws InterruptedException {
        System.out.println("send data=========>" + str);
        arrayBlockingQueue.add(str);
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueueDemo abq = new ArrayBlockingQueueDemo();
        for (int i = 0; i < 5; i++) {
            abq.sendData("Data" + i);
        }
    }
}
