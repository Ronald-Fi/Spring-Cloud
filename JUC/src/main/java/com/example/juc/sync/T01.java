package com.example.juc.sync;

public class T01 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {//任何线程想要执行下表面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
