package com.baidan.springCode.module.ordering.demo1;

import java.io.IOException;

public class ThisEscape2 {
    private int num = 9;

    public ThisEscape2() {
        new Thread(()-> {
            System.out.println(this.num==0?"000000000000000000000":"");
        }).start();
        /*new Thread() {
            @Override
            public void run() {
                System.out.println(num)
            }
        };*/
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100000 ; i++) {
            new ThisEscape2();
        }
        //System.in.read();
    }
}
