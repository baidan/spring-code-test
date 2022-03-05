package com.baidan.springCode.module.interrupt.demo1;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Slf4j
public class Interrupt_and_sync2 {
    private static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                synchronized (o){
                    log.info("time:{},T1线程持有锁",new Date());
                    SleepHelper.sleepSeconds(10);
                }
                log.info("time:{},T1线程结束",new Date());
            }
        };

        t1.start();
        SleepHelper.sleepSeconds(1);
        new StringBuffer();
        new StringBuilder();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (o){
                    log.info("time:{},T2线程持有锁",new Date());
                }
                log.info("time:{},T2线程结束",new Date());
            }
        };

        t2.start();
        SleepHelper.sleepSeconds(1);
        t2.interrupt();

    }

}

@Slf4j
class SleepHelper2{
    public static void sleepSeconds(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }
}
