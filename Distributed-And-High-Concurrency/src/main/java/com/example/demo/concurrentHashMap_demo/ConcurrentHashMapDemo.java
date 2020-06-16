package com.example.demo.concurrentHashMap_demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, Object> chm = new ConcurrentHashMap<>();
        Map<Object, Object> hashMap = new HashMap<>();
        //将不安全的集合变成安全的
        Collections.synchronizedMap(hashMap);
    }
}
