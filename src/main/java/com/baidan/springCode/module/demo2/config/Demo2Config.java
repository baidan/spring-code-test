package com.baidan.springCode.module.demo2.config;

import com.baidan.springCode.module.demo2.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Type;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 */
@Configuration
@ComponentScan(value = "com.baidan.springCode.module.demo2", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {Demo2TypeFilter.class})
}, useDefaultFilters = false)
public class Demo2Config {

    @Bean
    public Person person() {
        return new Person("邹攀", 30);
    }
}
