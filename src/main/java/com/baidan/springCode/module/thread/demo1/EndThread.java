package com.baidan.springCode.module.thread.demo1;

public class EndThread {

    public static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

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
            while (!isInterrupted()) {
                System.out.println(threadName + "：is run~");
            }
            //当前isInterrupted()调用的都是父类的方法,如果不是继承方式实现，用runnable接口判断使用Thread.currentThread().isInterrupted()
            System.out.println(threadName + "：是否中断了：" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
