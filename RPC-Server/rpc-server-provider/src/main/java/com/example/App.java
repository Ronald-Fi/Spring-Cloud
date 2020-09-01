package com.example;

import com.example.rest.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //实例化
        /*HelloServiceImpl service = new HelloServiceImpl();
        RPCProxyServer proxyServer = new RPCProxyServer();
        //发布
        proxyServer.publisher(service, 8080);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //context.start();
    }
}
