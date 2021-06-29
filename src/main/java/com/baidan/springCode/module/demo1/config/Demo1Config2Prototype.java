package com.baidan.springCode.module.demo1.config;

import com.baidan.springCode.module.demo1.entity.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.baidan.springCode.module.demo1")
public class Demo1Config2Prototype {
    @Scope("prototype")
    @Lazy
    @Bean
    public Person personPrototype() {
        System.out.println("给容器添加person......");
        return new Person("邹攀", 30);
    }
}
