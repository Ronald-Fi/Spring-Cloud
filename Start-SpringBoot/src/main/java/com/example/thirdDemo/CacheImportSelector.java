package com.example.thirdDemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CacheImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableDefineService.class.getName());
        //动态注入Bean :判断逻辑实现动态配置
        return new String[]{CacheService.class.getName()}; //返回的是一个固定的CacheService
    }
}
