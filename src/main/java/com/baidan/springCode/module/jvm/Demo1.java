package com.baidan.springCode.module.jvm;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public  class Demo1 {
    public static void main(String[] args) {
        BiFunction<A, Object, Boolean> equals = A::equals;
        I i1 = A::test2;
        I i2 = A::test2;
        I i3 = () -> {
            A.test2();
        };


        //匿名内部类实现I接口    实现I接口的方法
        Consumer<I> consumer = new Consumer<I>() {

            @Override
            public void accept(I i) {

            }

            @Override
            public Consumer<I> andThen(Consumer<? super I> after) {
                return Consumer.super.andThen(after);
            }
        };


        System.out.println(i1.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());
    }

    @FunctionalInterface
    public interface I {
        void test();
    }

    public static class A {
        static void  test2() {
            System.out.println("A");
        }
    }
}
