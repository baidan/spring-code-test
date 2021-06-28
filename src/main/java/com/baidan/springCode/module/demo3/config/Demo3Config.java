package com.baidan.springCode.module.demo3.config;

import com.baidan.springCode.module.demo3.entity.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 * ClassPathBeanDefinitionScanner 类路径Bean定义扫描
 * if (useDefaultFilters) {registerDefaultFilters();}
 */
@Configuration
public class Demo3Config {

    @Bean
    public Person personZouPan() {
        return new Person("邹攀", 30);
    }

    @Conditional(Demo3Condition2.class)
    @Bean
    public Person personYeHaiYang() {
        return new Person("叶海洋", 21);
    }

    @Conditional(Demo3Condition1.class)
    @Bean
    public Person personWangQianXiang() {
        return new Person("王乾祥", 21);
    }

}
