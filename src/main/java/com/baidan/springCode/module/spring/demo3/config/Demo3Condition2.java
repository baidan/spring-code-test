package com.baidan.springCode.module.spring.demo3.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Demo3Condition2 implements Condition {
    /**
     * @param context  条件上下文环境
     * @param metadata 注解元数据信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取到IOC正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前的环境变量
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("osName===" + osName);
        if (osName.contains("Centos")) {
            System.out.println("匹配到Windows");
            return true;
        }
        return false;
    }
}
