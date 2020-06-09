package com.example.demo.condition_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionNotify implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();//竞争锁
            System.out.println("begin - conditionNotify");
            condition.signal();//唤醒阻塞状态的线程
            System.out.println("end - conditionNotify");
            //condition.signalAll();
        } finally {
            lock.unlock();//释放锁
        }
    }
}
