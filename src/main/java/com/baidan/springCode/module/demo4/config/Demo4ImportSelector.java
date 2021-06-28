package com.baidan.springCode.module.demo4.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class Demo4ImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.baidan.springCode.module.demo4.entity.Fish"};
    }
}
