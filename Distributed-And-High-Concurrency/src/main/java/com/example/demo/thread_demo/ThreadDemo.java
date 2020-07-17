package com.example.demo.thread_demo;

public class ThreadDemo {
    public static void main(String[] args) {
        CountTool countTool = new CountTool();
        int count = 10;

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    //减少
                    countTool.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    //增加
                    countTool.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    //减少
                    countTool.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    //增加
                    countTool.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
