package com.example.juc.sync;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class T13 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        List<Object> list = new ArrayList<>();
        List<Object> linkedList = new LinkedList<>();
        HashSet<Object> hashSet = new HashSet<>();
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, Object> map = new HashMap<>();
        Object o = new Object();
        String s = new String();
        Iterator iterator = c.iterator();
    }
}