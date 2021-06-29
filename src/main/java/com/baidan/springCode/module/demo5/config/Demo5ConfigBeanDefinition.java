package com.baidan.springCode.module.demo5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Description("攀哥")
@Configuration
@ComponentScan("com.baidan.springCode.module.demo5")
public class Demo5ConfigBeanDefinition {
    public Demo5ConfigBeanDefinition() {
        System.out.println("Demo5Config实例化");
    }
}
