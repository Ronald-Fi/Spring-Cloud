package com.example.service;

import com.example.domain.User;

public interface IHelloService {

    String sayHello(String content);

    String saveUser(User user);

}
