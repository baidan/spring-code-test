package com.baidan.springCode.module.spring.demo5.entity;

public class Cat {
    public Cat() {
        System.out.println("---无参CAT---");
        System.out.println(this);
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
