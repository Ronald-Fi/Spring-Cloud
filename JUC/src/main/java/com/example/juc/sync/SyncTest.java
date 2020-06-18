package com.example.juc.sync;

public class SyncTest {
    Object lock;
    public SyncTest(Object lock){
        this.lock=lock;
    }
    public void demo(){
        synchronized (lock){ // lock表示锁对象  在JVM里面有堆存储  并且1、2 是通过JVM进行实现的
            // 2、线程A未执行完同步代码块、线程B进行访问、会将当前偏向锁升级未轻量级锁
        }
        // 1、线程A执行完同步代码块会释放偏向锁、并将markwold中的线程ID置为空、从而无锁化
    }
    public static void main(String[] args) {
        Object lock=new Object();
        SyncTest syncTest = new SyncTest(lock);
        SyncTest syncTest2 = new SyncTest(lock);
        new Thread(()->syncTest.demo()).start();
        new Thread(()->syncTest2.demo()).start();
    }
}
