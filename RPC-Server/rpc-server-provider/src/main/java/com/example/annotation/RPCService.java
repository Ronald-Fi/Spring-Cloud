package com.example.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//类、接口
@Target(ElementType.TYPE)
//运行时
@Retention(RetentionPolicy.RUNTIME)
//交给Spring管理
@Component
public @interface RPCService {

    //拿到服务的接口
    Class<?> value();

    /**
     * 版本号
     */
    String version() default "";

}
