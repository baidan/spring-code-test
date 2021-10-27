package com.baidan.springCode.module.thread.demo2;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Synchronized {
    private static int num = 0;

    private static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        //调用到了OS的p_thread_create方法，OS回调了run方法,CPU切片切到谁，谁执行
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            //system.out.println输出是同步的，加了锁,并发编程时候测试打印，可能结果不正确
            /**
             * public void println(String x) {
             *         synchronized (this) {
             *             print(x);
             *             newLine();
             *         }
             *     }
             */

            //System.out.println(threadName + "：开始抢锁中...");
            log.info(threadName + "：开始抢锁中...");
            synchronized (this) {
                //System.out.println(threadName + "：抢到了锁-------------------，其余线程在等待中，状态为阻塞");
                log.info(threadName + "：抢到了锁-------------------，其余线程在等待中，状态为阻塞");
                for (int i = 0; i <= 9999; i++) {
                    int temp = num;
                    temp = temp + 1;
                    num = temp;
                }
                //System.out.println(threadName + "：线程持有操作：num=" + num);
                log.info(threadName + "：线程持有操作后结果：num=" + num);


                try {
                    //public static native void sleep
                    //此时会进入到内核态
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info(threadName + "：预准备释放锁-------------------");
            }
            log.info(threadName + "：已经释放了锁-------------------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //有三个对象，三个线程，锁不了三个对象,多个对象不适用与synchronized锁
        /*Synchronized.UseThread endThread1 = new Synchronized.UseThread("useThread1");
        Synchronized.UseThread endThread2 = new Synchronized.UseThread("useThread2");
        Synchronized.UseThread endThread3 = new Synchronized.UseThread("useThread3");
        endThread1.start();
        endThread2.start();
        endThread3.start();*/

        //同一个对象锁，交个三个线程
        UseThread useThread = new UseThread("useThread");
        Thread thread1 = new Thread(useThread);
        Thread thread2 = new Thread(useThread);
        Thread thread3 = new Thread(useThread);
        Thread thread4 = new Thread(useThread);
        Thread thread5 = new Thread(useThread);
        Thread thread6 = new Thread(useThread);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread4.setName("thread4");
        thread5.setName("thread5");
        thread6.setName("thread6");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
