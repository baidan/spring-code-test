package com.baidan.springCode.module.demo1.config;

import com.baidan.springCode.module.demo1.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.baidan.springCode.module.demo1")
public class Demo1Config {

    /*@Bean("person123")
    public Person person(){
        return  new Person("邹攀",30);
    }*/
}
