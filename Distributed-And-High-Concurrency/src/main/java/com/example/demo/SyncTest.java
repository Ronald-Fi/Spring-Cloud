package com.example.demo;

public class SyncTest {
    Object lock;
    public SyncTest(Object lock){
        this.lock=lock;
    }
    public void demo(){
        synchronized (lock){

        }
    }
    public static void main(String[] args) {
        Object lock=new Object();
        SyncTest syncTest = new SyncTest(lock);
        SyncTest syncTest2 = new SyncTest(lock);
        new Thread(()->syncTest.demo()).start();
        new Thread(()->syncTest2.demo()).start();
    }
}
