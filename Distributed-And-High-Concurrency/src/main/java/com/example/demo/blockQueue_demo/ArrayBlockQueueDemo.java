package com.example.demo.blockQueue_demo;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockQueueDemo {
    ArrayBlockingQueue<String> abq = new ArrayBlockingQueue(10, false);//FIFO的队列 先进先出

    {
        init();//构造块初始化
    }

    public void init() {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("take start");
                    String data = abq.take();//阻塞方式获得元素l
                    System.out.println("receive:" + data + "take end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendData(String data) throws InterruptedException {
        abq.add(data);
        System.out.println("send data=========>" + data);
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockQueueDemo abqd = new ArrayBlockQueueDemo();
        for (int i = 0; i < 100; i++) {
            abqd.sendData("data:" + i);
        }
    }
}
