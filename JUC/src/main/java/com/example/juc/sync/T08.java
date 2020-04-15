package com.example.juc.sync;

/**
 * 同步方法和非同步方法是否可以同时调用？
 */
public class T08 {
    private int count = 10;

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start ... ");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start ... ");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }

    public static void main(String[] args) {
        T08 t = new T08();
//        new Thread(()->t.m1(),"t1").start();
//        new Thread(()->t.m2(),"t2").start();
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();
    }
}
