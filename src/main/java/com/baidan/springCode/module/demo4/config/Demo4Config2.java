package com.baidan.springCode.module.demo4.config;

import com.baidan.springCode.module.demo4.entity.Cat;
import com.baidan.springCode.module.demo4.entity.Dog;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * useDefaultFilters = false  不使用默认的过滤类型， 默认按照注解类型过滤
 * ClassPathBeanDefinitionScanner 类路径Bean定义扫描
 * if (useDefaultFilters) {registerDefaultFilters();}
 */
@Configuration
@Import(value = {Cat.class, Dog.class, Demo4ImportSelector.class, Demo4ImportBeanDefinitionRegistrar.class})
public class Demo4Config2 {

}
