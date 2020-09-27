package com.company.threadcoreknowledge.threadobjectclass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description     演示sleep 不释放lock（lock需要手动释放）
 * @Author lijiangtao
 * @Date 2020/9/17 22:30
 * @Version 1.0
 */
public class SleepDontReleasesLock implements Runnable{
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
lock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"已经苏醒");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleasesLock sleepDontReleasesLock = new SleepDontReleasesLock();
        new Thread(sleepDontReleasesLock).start();
        new Thread(sleepDontReleasesLock).start();
    }
}
