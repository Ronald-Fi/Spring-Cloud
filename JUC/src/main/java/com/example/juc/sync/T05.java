package com.example.juc.sync;

public class T05 {
    private static int count = 10;

    public synchronized static void m() {//等同于在方法的代码执行synchronized (T05.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public void mm() {
        synchronized (T05.class) {
            count--;
        }
    }
}
