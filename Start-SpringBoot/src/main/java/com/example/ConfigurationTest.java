package com.example;

import org.springframework.context.annotation.*;

public class ConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        ConfigurationDemo contextBean = applicationContext.getBean(ConfigurationDemo.class);
        contextBean.sayHello();
    }
}

@Configuration
class ConfigurationDemo {
    @Bean
    @Scope(proxyMode = ScopedProxyMode.DEFAULT)
    public void sayHello() {
        System.out.println("Say Hello : Ron");
    }
}
