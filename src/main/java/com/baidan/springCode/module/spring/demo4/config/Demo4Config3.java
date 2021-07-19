package com.baidan.springCode.module.spring.demo4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 * ClassPathBeanDefinitionScanner 类路径Bean定义扫描
 * if (useDefaultFilters) {registerDefaultFilters();}
 */
@Configuration
@Import(value = {Demo4FactoryBean.class})
public class Demo4Config3 {

    @Bean
    public Demo4FactoryBean demo4FactoryBean() {
        return new Demo4FactoryBean();
    }
}
