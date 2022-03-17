package com.baidan.springCode.module.designPatterns.factory;

public class Demo1 {
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