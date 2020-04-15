package com.example.juc.sync;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说sync获得的锁是可重入的
 * 这里是继承中可能放生的情形，子类调用父类的同步方法
 */
public class T11_Dad {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new T11_Son().m();
    }
}

class T11_Son extends T11_Dad {
    @Override
    synchronized void m() {
        System.out.println("son start");
        super.m();
        System.out.println("son end");
    }
}
