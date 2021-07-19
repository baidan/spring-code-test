package com.baidan.springCode.module.spring.demo1.service.impl;

import com.baidan.springCode.module.spring.demo1.service.IXservice;
import org.springframework.stereotype.Service;

@Service
public class XserviceImpl implements IXservice {
    public XserviceImpl() {
        System.out.println(this);
        System.out.println("i,m XserviceImpl");
    }

    public void zSHasKey() {

    }
}
