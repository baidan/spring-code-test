package com.baidan.springCode.module.demo1.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Xdao {
    public Integer num;

    public Xdao() {
        System.out.println("Xdao:空参数构造~");
    }

    public Xdao(Integer num) {
        this.num = num;
        System.out.println("Xdao:有参数构造~");
    }

    public int getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
