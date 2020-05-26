package com.example.demo.wait_notify_demo;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Object lock=new Object();
        ThreadA threadA=new ThreadA(lock);
        ThreadB threadB=new ThreadB(lock);
        threadA.start();
        threadB.start();
    }
}
