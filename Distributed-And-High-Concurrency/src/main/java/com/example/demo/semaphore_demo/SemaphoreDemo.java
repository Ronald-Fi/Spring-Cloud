package com.example.demo.semaphore_demo;

import java.util.concurrent.Semaphore;

//限流
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }
    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;
        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();//获得一个令牌 拿不到令牌就会阻塞
                System.out.println("第" + num + "抢占一个车位");
                Thread.sleep(2000);
                System.out.println("第" + num + "辆车开走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
