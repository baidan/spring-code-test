package com.baidan.springCode.module.spring.demo1.config;

import com.baidan.springCode.module.spring.demo1.entity.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
/*@ComponentScan("com.baidan.springCode.module.spring.demo1")*/
public class Demo1Config {
    public Demo1Config (){
        //System.out.println("空参构造：------Demo1Config实例化------");
    }
    //@Bean: 导入第三方类或者包的组件
    @Bean("person123")
    public Person person(){
        return new Person("邹攀",30);
    }
}
