package com.example.impl;

import com.example.annotation.RPCService;
import com.example.domain.User;
import com.example.service.IHelloService;

@RPCService(value = IHelloService.class, version = "v1.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("【v1.0】request in sayHello" + content);
        return "【v1.0】Say Hello" + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v1.0】request in saveUser" + user.toString());
        return "【v1.0】SUCCESS";
    }
}
