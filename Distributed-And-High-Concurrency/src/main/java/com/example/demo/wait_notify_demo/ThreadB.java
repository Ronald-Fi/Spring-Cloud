package com.example.demo.wait_notify_demo;

public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("start ThreadB");
            lock.notify(); // 唤醒等待队列中被阻塞的线程->进入到同步队列->指令成功之后继续执行
            System.out.println("end ThreadB");
        }
    }
}
