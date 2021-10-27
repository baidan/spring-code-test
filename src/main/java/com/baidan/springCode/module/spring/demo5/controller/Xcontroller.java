package com.baidan.springCode.module.spring.demo5.controller;

import com.baidan.springCode.module.spring.demo5.entity.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Xcontroller {
    public static void main(String[] args) {
        List<HashMap> list = new ArrayList<>();
        HashMap m1 = new HashMap();
        m1.put("a",1123);
        m1.put("b",1124);
        m1.put("c",1125);
        m1.put("d",1125);
        list.add(m1);
        HashMap m2 = new HashMap();
        m2.put("d",1126);
        m2.put("e",1127);
        m2.put("f",1128);
        list.add(m2);
        Dog dog = new Dog("aaa",12,null);



        dog.setDogId(
                list.stream().map(
                        info-> 1
                ).reduce(Integer::sum).get()
        );
        System.out.println(dog.toString());
    }
}
