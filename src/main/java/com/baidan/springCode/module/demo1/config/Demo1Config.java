package com.baidan.springCode.module.demo1.config;

import com.baidan.springCode.module.demo1.entity.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.baidan.springCode.module.demo1")
public class Demo1Config {
    //@Bean: 导入第三方类或者包的组件
    /*@Bean("person123")
    public Person person(){
        return  new Person("邹攀",30);
    }*/
}
