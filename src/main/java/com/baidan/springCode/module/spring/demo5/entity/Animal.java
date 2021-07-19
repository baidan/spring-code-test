package com.baidan.springCode.module.spring.demo5.entity;

public class Animal {
    private String type;

    public Animal(String type) {
        this.type = type;
        System.out.println("---有参Animal---");
    }

    public Animal() {
        System.out.println("---无参Animal---");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
