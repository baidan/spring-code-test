package com.baidan.springCode.module.configCode.config;

import com.baidan.springCode.module.configCode.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.baidan.springCode")
public class ConfigClass {

    @Bean("person123")
    public Person person(){
        return  new Person("邹攀",30);
    }
}
