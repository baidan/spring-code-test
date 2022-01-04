package com.baidan.springCode.module.spring.demo1.entity;

public class Person {
    public String name;
    public Integer age;

    public Person() {
        System.out.println("空参构造：------person实例化------");
        System.out.println(this.toString());
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        //System.out.println("有参构造：------person实例化------");
        //System.out.println(this.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

/*    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
