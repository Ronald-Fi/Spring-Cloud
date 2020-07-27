package com.example;

import com.example.impl.HelloServiceImpl;
import com.example.proxy.RPCProxyServer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //实例化
        HelloServiceImpl service = new HelloServiceImpl();
        RPCProxyServer proxyServer = new RPCProxyServer();
        //发布
        proxyServer.publisher(service, 8080);
    }
}
