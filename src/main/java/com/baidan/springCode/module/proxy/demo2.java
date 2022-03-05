package com.baidan.springCode.module.proxy;

import java.util.Random;

public class demo2 implements moveClass {
    @Override
    public void move(){
        long stime = System.currentTimeMillis();
        try {
            System.out.println("move,move,move");
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis();
        System.out.println(etime-stime);
    }

    public static void main(String[] args) {
        new demo2().move();
    }
}

interface moveClass{
    void move();
}



interface  IPhone{}
interface  IMask{}

class APhone implements IPhone{
    APhone(){
        System.out.println("Creat APhone");
    }
}
class AMask implements IMask{
    AMask(){
        System.out.println("Creat AMask");
    }
}
interface  AbstractFactory{
    IPhone createIphone(String param);
    IMask createImask(String param);
}
class ActionFactory implements AbstractFactory{

    @Override
    public IPhone createIphone(String param) {
        return new APhone();
    }

    @Override
    public IMask createImask(String param) {
        return new AMask();
    }

    public static void main(String[] args) {
        new ActionFactory().createIphone("dd");
    }
}