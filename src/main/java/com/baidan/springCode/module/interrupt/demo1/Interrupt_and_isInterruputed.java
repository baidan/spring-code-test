package com.baidan.springCode.module.interrupt.demo1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Interrupt_and_isInterruputed {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

        });

        Interrupt_and_isInterruputed interrupt_and_isInterruputed = new Interrupt_and_isInterruputed() {
            {
                System.out.println("2==================");
            }
        };

        Thread thread1 = new Thread() {
            public void run() {
                int i = 0;
                for (; ; ) {
                    i++;
                    System.out.println(i);
                    //log.info(i+"");
                    if (i == 16000) {
                        System.out.println(i+"---------------------------------------------------");
                        //log.info(i+"-----------------------");
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().isInterrupted());
                        break;
                    }
                }
            }
        };

        thread1.start();
        Thread.sleep(500);
        //设置打断标志位
        thread1.interrupt();
    }
}
