package com.example.secondDemo.current;

import com.example.secondDemo.other.OtherConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(OtherConfig.class)
@Configuration
public class SpringConfig {
    @Bean
    public DefaultBean defaultBean() {
        return new DefaultBean();
    }
}
