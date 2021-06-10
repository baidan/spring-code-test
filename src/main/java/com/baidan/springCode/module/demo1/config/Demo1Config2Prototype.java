package com.baidan.springCode.module.demo1.config;

import com.baidan.springCode.module.demo1.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.baidan.springCode.module.demo1")
public class Demo1Config2Prototype {
    //@Scope("prototype")
    //@Bean
    /*public Person personPrototype() {
        System.out.println("给容器添加person......");
        return new Person("邹攀", 30);
    }*/
}
