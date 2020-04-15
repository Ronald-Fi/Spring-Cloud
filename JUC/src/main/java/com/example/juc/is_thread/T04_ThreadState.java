package com.example.juc.is_thread;

public class T04_ThreadState {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("线程结束");
        }
        System.out.println(t.getState());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }
}
