package com.example.juc.sync;


public class T07 implements Runnable {
    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            T07 t = new T07();
            new Thread(t, "THREAD" + i).start();
        }
    }
}
