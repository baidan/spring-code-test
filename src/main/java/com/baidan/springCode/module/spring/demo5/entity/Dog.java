package com.baidan.springCode.module.spring.demo5.entity;

import lombok.Data;

@Data
public class Dog {
    public String name;
    public Integer  age;
    public Integer dogId;

    public Dog(String name, Integer age, Integer dogId) {
        this.name = name;
        this.age = age;
        this.dogId = dogId;
    }

    public Integer getDogId(Object obj) {
        System.out.println("obj==="+obj);
        return dogId;
    }

    private Dog() {
        System.out.println("I'm dog");
        System.out.println(this);
    }
}
