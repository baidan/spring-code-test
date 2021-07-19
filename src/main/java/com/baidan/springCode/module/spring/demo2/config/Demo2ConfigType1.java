package com.baidan.springCode.module.spring.demo2.config;

import com.baidan.springCode.module.spring.demo2.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 * ClassPathBeanDefinitionScanner 类路径Bean定义扫描
 * if (useDefaultFilters) {registerDefaultFilters();}
 */
@Configuration
@ComponentScan(value = "com.baidan.springCode.module.spring.demo2", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {Demo2TypeFilter.class})
}, useDefaultFilters = true)
public class Demo2ConfigType1 {
    static {
        //ClassPathBeanDefinitionScanner a = new ClassPathBeanDefinitionScanner("a", "b", "c", "d");
    }

    @Bean
    public Person person() {
        return new Person("邹攀", 30);
    }

}
