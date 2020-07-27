package com.example;

import com.example.proxy.RPCProxyClient;
import com.example.service.IHelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
        RPCProxyClient rpcProxyClient = new RPCProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String result = iHelloService.sayHello("Ron");
        System.out.println(result);
    }
}
