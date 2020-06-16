package com.example.demo.cyclicBarrier_demo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo extends Thread{
    @Override
    public void run() {
        System.out.println("开始分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3,new CyclicBarrierDemo());
        new Thread(new DataImportThread(cyclicBarrier,"路径1")).start();
        new Thread(new DataImportThread(cyclicBarrier,"路径2")).start();
        new Thread(new DataImportThread(cyclicBarrier,"路径3")).start();
    }
}
