package com.example.juc.sync;

public class T02 {
    private int count = 10;

    public void m() {
        synchronized (this) {//任何线程想要执行下表面的代码，必须先拿到当前对象的这把锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
