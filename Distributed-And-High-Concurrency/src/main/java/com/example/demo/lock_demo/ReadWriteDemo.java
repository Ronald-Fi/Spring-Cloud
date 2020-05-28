package com.example.demo.lock_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo {

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Map<String, Object> map = new HashMap<>();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static final Object get(String key) {
        System.out.println("begin get key start:" + key);
        read.lock();
        try {
            return map.get(key);
        } finally {
            read.unlock();
            System.out.println("begin get key end");
        }
    }

    public static final Object put(String key, Object val) {
        System.out.println("put method start");
        write.lock();
        try {
            return map.put(key, val);
        } finally {
            write.unlock();
            System.out.println("put method end");
        }
    }

    public static void main(String[] args) {
        rwl.readLock();// 读锁  加读锁的时候如果没有写操作的时候该方法是不会阻塞的

        rwl.writeLock();// 写锁
        // A线程正在写、B线程正在读->B线程阻塞
        // 读和写是互斥的
        // 读和读可以共享的
        // 写饿写是互斥的
        // 互斥可以理解成阻塞
        // 适用于读多写少的场景
    }
}
