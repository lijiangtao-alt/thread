package com.company.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description volatile 适用的情况1
 * @Author lijiangtao
 * @Date 2020/9/25 19:57
 * @Version 1.0
 */
public class UseVolatile implements Runnable{

    volatile boolean done = false ;
    static AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new UseVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((UseVolatile) r).done);
        System.out.println(realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }
}
