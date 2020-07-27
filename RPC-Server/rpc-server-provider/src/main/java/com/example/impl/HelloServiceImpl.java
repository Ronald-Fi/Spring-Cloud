package com.example.impl;

import com.example.annotation.RPCService;
import com.example.domain.User;
import com.example.service.IHelloService;

@RPCService(IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("request in sayHello" + content);
        return "Say Hello" + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("request in saveUser" + user.toString());
        return "SUCCESS";
    }
}
