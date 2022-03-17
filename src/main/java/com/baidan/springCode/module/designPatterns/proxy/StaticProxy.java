package com.baidan.springCode.module.designPatterns.proxy;

import java.util.Random;

public class StaticProxy {
}

class TargetObj implements ActionClass {
    public static TargetObj targetObj;

    public TargetObj() {
    }


    public static synchronized TargetObj getTargetObjInstance() {
        if (null == targetObj) {
            targetObj = new TargetObj();
        }
        return targetObj;
    }

    @Override
    public void actionFn() {
        try {
            System.out.println("move,move,move");
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ActionObj {
    public static void main(String[] args) {
        new TimeProxy(new LogPrixy(TargetObj.getTargetObjInstance())).actionFn();
    }

}

class LogPrixy implements ActionClass {
    ActionClass Ac;

    public LogPrixy(ActionClass ac) {
        this.Ac = ac;
    }
    //TargetObj targetObj = TargetObj.getTargetObjInstance();

    @Override
    public void actionFn() {
        Ac.actionFn();
        System.out.println("记录操作日志：xxxx");
    }
}

class TimeProxy implements ActionClass {
    ActionClass Ac;
    //TargetObj targetObj = TargetObj.getTargetObjInstance();

    public TimeProxy(ActionClass ac) {
        this.Ac = ac;
    }

    @Override
    public void actionFn() {
        long stime = System.currentTimeMillis();
        Ac.actionFn();
        long etime = System.currentTimeMillis();
        System.out.println("记录操作时间:"+ (etime - stime));
    }
}


interface ActionClass {
    void actionFn();
}


