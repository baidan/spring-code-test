package com.baidan.springCode.module.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        //TargetObj targetObjInstance = TargetObj.getTargetObjInstance();
        TargetObj targetObjInstance = new TargetObj();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        ActionClass actionClass = (ActionClass) Proxy.newProxyInstance(TargetObj.class.getClassLoader(), new Class[]{ActionClass.class}, new AllProxy(targetObjInstance));
        actionClass.actionFn();
    }
}

class AllProxy implements InvocationHandler {
    ActionClass ac;

    public AllProxy(ActionClass ac) {
        this.ac = ac;
    }

    public void before() {
        System.out.println("start...");
    }

    public void after() {
        System.out.println("end...");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(ac, args);
        after();
        return invoke;
    }
}




