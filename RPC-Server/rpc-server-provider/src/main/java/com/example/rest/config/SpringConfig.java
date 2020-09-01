package com.example.rest.config;

import com.example.server.RPCServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringConfig {
    //定义Bean
    @Bean(name = "RPCServer")
    public RPCServer rpcServer() {
        return new RPCServer(8080);
    }
}
