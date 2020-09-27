package com.company.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 不适用 volatile 的场景
 * @Author lijiangtao
 * @Date 2020/9/25 19:14
 * @Version 1.0
 */
public class NoVolatile implements Runnable{
    volatile int a;
    static AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new NoVolatile();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile) r).a);
        System.out.println(realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            realA.incrementAndGet();
        }
    }
}
