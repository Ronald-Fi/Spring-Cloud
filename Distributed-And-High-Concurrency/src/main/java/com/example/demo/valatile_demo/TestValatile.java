package com.example.demo.valatile_demo;

public class TestValatile {
    //    public volatile static boolean stop = false; //保证可见性
    public static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
                System.out.println(i);
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.join();
        stop = true;
        // 断言
        assert stop=false;
    }
}
