package com.example.secondDemo.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {
    @Bean
    public OtherBean otherBean() {
        //不能动态注入
        return new OtherBean();
    }
}
