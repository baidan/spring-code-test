package com.baidan.springCode.module.spring.demo5.processor;

import com.baidan.springCode.module.spring.demo5.entity.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author BaiDan
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //通过bean工厂拿到业务类InterService的beanDefinition
        /*GenericBeanDefinition beanDefinition =
                (GenericBeanDefinition) beanFactory.getBeanDefinition("demo5ConfigBeanDefinition");
        System.out.println("扫描注册成功完成后，spring自动调用次方法");
        System.out.println(beanDefinition.getDescription());
        System.out.println(beanDefinition.getBeanClassName());
        System.out.println("开始偷梁换柱");
        beanDefinition.setBeanClass(Cat.class);*/

        GenericBeanDefinition beanDefinition1 = null;
        String BeanName = "demo5ConfigBeanDefinition";
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
       /* Iterator<String> iterator = Arrays.stream(beanDefinitionNames).iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next == BeanName) {
                beanDefinition1 = (GenericBeanDefinition) beanFactory.getBeanDefinition(BeanName);
            }
            System.out.println("beanDefinitionName===" + next);
        }*/

        for (String beanDefinitionName : beanDefinitionNames) {
            if (beanDefinitionName == BeanName) {
                beanDefinition1 = (GenericBeanDefinition) beanFactory.getBeanDefinition(BeanName);
            }
            System.out.println("beanDefinitionName===" + beanDefinitionName);
        }
    }
}
