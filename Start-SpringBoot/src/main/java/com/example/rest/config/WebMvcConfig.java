package com.example.rest.config;

import com.example.rest.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //converters.add(0, new MappingJackson2XmlHttpMessageConverter());
        converters.add(new PropertiesPersonHttpMessageConverter());
    }
}
