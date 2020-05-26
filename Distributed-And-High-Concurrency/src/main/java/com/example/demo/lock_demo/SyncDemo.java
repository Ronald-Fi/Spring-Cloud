package com.example.demo.lock_demo;

public class SyncDemo {
    public synchronized void demo1() {// 获得对象锁
        System.out.println("demo1");
        demo2();
    }

    public void demo2() {
        synchronized (this) {// 再次获得对象锁
            System.out.println("demo2");
        }
    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.demo1();
    }
}
