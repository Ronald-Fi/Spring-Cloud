package com.example.juc.is_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hello Lambda");
        }).start();
        ExecutorService executors = Executors.newCachedThreadPool();
    }
}
