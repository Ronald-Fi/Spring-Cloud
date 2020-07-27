package com.example.config;

import com.example.proxy.RPCProxyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringConfig {
    //定义Bean
    @Bean(name = "RPCProxyClient")
    public RPCProxyClient proxyClient() {
        return new RPCProxyClient();
    }
}
