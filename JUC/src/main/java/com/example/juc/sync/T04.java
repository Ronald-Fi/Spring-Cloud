package com.example.juc.sync;

public class T04 {
    private int count = 10;

    public synchronized void m() {//等同于在方法的代码执行时要synchronized (this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public void n() {
        count++;
    }
}
