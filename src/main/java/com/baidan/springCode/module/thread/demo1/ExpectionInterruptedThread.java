package com.baidan.springCode.module.thread.demo1;

public class ExpectionInterruptedThread {

    private static class UseThread implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            /**
             *  1,Java中的多线程运行机制是协作式[不建议使用历史方法:stop(暴力停止，来不及释放资源),
             *  resume(恢复,继续),suspend(暂停,挂起，容易死锁)]；而暂停和恢复操作经常使用到的是线程的等待、通知机制！（wait和notify）
             *  Thread.suspend方法是天生易发生死锁的。
             * 如果要suspend的目标线程对一个重要的系统资源持有锁，那么没任何线程可以使用这个资源直到要suspend的目标线程被resumed。
             * 如果一条线程将去resume目标线程之前尝试持有这个重要的系统资源再去resume目标线程，这两条线程就相互死锁了。
             *
             *
             *  2,三个判断方法：是否中断：isInterrupted();  是否为守护线程：isDaemon();  线程是否存活：isAlive()。
             */
            //当线程内部没有被自己中断时继续执行。
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(100);
                    //在Java中，阻塞都会抛出 InterruptedException异常
                } catch (InterruptedException e) {
                    System.out.println(threadName + "：是否中断了：" + Thread.currentThread().isInterrupted());
                    //当方法抛出InterruptedException异常的时候，线程的标志位会被恢复成false，需要我们自己在catch块中中断
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println(threadName + "：is run~");
            }
            //当前isInterrupted()调用的都是父类的方法,如果不是继承方式实现，用runnable接口判断使用Thread.currentThread().isInterrupted()
            System.out.println(threadName + "：是否中断了：" + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        //endThread.run();//如果没有用thread类调用，这就是一个普通的run方法

        //虽然可以用runnable接口实现，但是调用的时候还是需要，否则就是一个普通的run方法；用thread对象包装一下, 第二个参数可以传入线程的自定义名称
        Thread endThread = new Thread(useThread, "ify-thread-1000");
        endThread.start();
        Thread.sleep(50);
        endThread.interrupt();
    }
}
