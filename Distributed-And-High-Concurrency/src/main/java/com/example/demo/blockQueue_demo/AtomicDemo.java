package com.example.demo.blockQueue_demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static volatile int count;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static void incr() {
        count++;
        atomicInteger.incrementAndGet();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::incr).start();
        }
        System.out.println(count);
        System.out.println(atomicInteger);
    }
}
