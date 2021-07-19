package com.baidan.springCode.module.spring.demo5.config;

/*@ComponentScan("com.baidan.springCode.module.spring.demo5")*/
public class Demo5Config extends Thread {
    public Demo5Config() {
        System.out.println("Demo5Config实例化");
    }

    private String name;
    private int age;
}
