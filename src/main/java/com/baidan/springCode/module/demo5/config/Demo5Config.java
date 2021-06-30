package com.baidan.springCode.module.demo5.config;

import org.springframework.context.annotation.ComponentScan;

/*@ComponentScan("com.baidan.springCode.module.demo5")*/
public class Demo5Config extends Thread {
    public Demo5Config() {
        System.out.println("Demo5Config实例化");
    }

    private String name;
    private int age;
}
