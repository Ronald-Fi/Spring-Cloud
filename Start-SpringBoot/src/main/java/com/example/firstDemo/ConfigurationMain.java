package com.example.firstDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
public class ConfigurationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationMain.class);
        String[] defNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < defNames.length; i++) {
            System.out.println(defNames[i]);
        }
    }
}
