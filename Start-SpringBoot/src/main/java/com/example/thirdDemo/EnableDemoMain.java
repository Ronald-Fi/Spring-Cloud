package com.example.thirdDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDefineService
public class EnableDemoMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext ca = SpringApplication.run(EnableDemoMain.class, args);
        System.out.println(ca.getBean(CacheService.class));
        System.out.println(ca.getBean(LoggerService.class));
    }
}
