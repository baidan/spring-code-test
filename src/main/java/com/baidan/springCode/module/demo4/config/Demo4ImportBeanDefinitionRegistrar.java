package com.baidan.springCode.module.demo4.config;

import com.baidan.springCode.module.demo4.entity.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class Demo4ImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b1 = registry.containsBeanDefinition("com.baidan.springCode.module.demo4.entity.Cat");
        boolean b2 = registry.containsBeanDefinition("com.baidan.springCode.module.demo4.entity.Dog");
        if (b1 && b2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", rootBeanDefinition);
        }
    }
}
