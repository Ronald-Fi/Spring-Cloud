package com.example.demo.lock_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();//获得一个锁
        //业务逻辑
        lock.unlock();//释放锁
        boolean interrupted = Thread.interrupted();//当前线程是否被中断挂起过
    }
}
