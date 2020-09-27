package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description 两个线程交替打印0~100的奇偶数，用wait和 notify 实现
 * @Author lijiangtao
 * @Date 2020/9/17 21:28
 * @Version 1.0
 */
public class WaitNotifyPrintOddEveWait {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TuringRunner(),"偶数").start();
        Thread.sleep(10);
        new Thread(new TuringRunner(),"奇数").start();
    }
    //1.拿到锁就打印
    //2.打印完，唤醒其他线程，自己就休眠
    static class TuringRunner implements Runnable{

        @Override
        public void run() {
            while (count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();
                    if (count<=100){
                        try {
                            //如果任务还没有结束，就让出当前的锁，并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
