package com.baidan.springCode.module.demo1.config;

import com.baidan.springCode.module.demo1.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Demo1Config3Lazy {
    /*@Lazy
    @Bean
    public Person personLazy() {
        System.out.println("给容器添加person......");
        return new Person("邹攀", 30);
    }*/
}
