package com.company.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description volatile 不适用的情况2
 * 如果一个共享变量自始至终只被各个现场赋值，而没有其他的操作，那么就可以用volatile来代替
 * synchronize或者代替原子变量，因为赋值，自身是有原子性的，而volatile又保证了可见性，所以保证线程安全
 *
 * @Author lijiangtao
 * @Date 2020/9/25 19:57
 * @Version 1.0
 */
public class NoVolatile2 implements Runnable{

    volatile boolean done = false ;
    static AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new NoVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile2) r).done);
        System.out.println(realA.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            flipDone();
            realA.incrementAndGet();
        }
    }

    private void flipDone() {
        done = !done;
    }
}
