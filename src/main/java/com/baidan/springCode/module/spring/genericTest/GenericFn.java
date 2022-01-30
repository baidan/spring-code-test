package com.baidan.springCode.module.spring.genericTest;

public class GenericFn {
    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());

        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        Fu firstFu = new Fu("fu1");
        Fu lastFu = new Fu("fu2");
        Pair<Fu> fu1 = new Pair<>(firstFu,lastFu);
        Zi zi1 = new Zi();
        addPerson(fu1,zi1);

    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }


    static  void  addPerson(Pair<? super Zi> p, Zi n){
        p.setFirst(n);
        p.setLast(n);
    }

}



class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}


class Person{
    Person(){
        System.out.println("Person");
    }
}

class Fu extends Person{
    String name;
    Fu(){
        System.out.println("Fu");
    }

    public Fu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Zi extends Fu{
    Zi(){
        System.out.println("Zi");
    }
}
