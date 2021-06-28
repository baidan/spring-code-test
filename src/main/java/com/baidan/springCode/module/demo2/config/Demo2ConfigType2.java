package com.baidan.springCode.module.demo2.config;

import com.baidan.springCode.module.demo2.entity.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 * ClassPathBeanDefinitionScanner 类路径Bean定义扫描
 * if (useDefaultFilters) {registerDefaultFilters();}
 */
@Configuration
@ComponentScan(value = "com.baidan.springCode.module.demo2", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
}, useDefaultFilters = false)
public class Demo2ConfigType2 {
    static {
        //ClassPathBeanDefinitionScanner a = new ClassPathBeanDefinitionScanner("a", "b", "c", "d");
    }

    @Bean
    public Person person() {
        return new Person("邹攀", 30);
    }

}
