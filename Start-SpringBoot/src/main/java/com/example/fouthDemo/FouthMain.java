package com.example.fouthDemo;

import com.example.thirdDemo.EnableDemoMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FouthMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableDemoMain.class, args);
        //System.out.println(context.getBean(RonCore.class));
    }
}
