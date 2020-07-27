package com.example.impl;

import com.example.annotation.RPCService;
import com.example.domain.User;
import com.example.service.IHelloService;

@RPCService(value = IHelloService.class, version = "v2.0")
public class HelloServiceImpl2 implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("【v2.0】request in sayHello" + content);
        return "【v2.0】Say Hello" + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v2.0】request in saveUser" + user.toString());
        return "【v2.0】SUCCESS";
    }
}
