package com.example.demo.condition_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        try {
            Lock lock = new ReentrantLock();
            Condition condition = lock.newCondition();
            new Thread(new ConditionWait(lock, condition)).start();
            new Thread(new ConditionNotify(lock, condition)).start();
        } finally {

        }
    }
}
