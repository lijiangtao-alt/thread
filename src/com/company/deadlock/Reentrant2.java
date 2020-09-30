package com.company.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author lijiangtao
 * @Date 2020/9/30 14:12
 * @Version 1.0
 */
public class Reentrant2 {
    public static void main(String[] args) {
        telPhone2 telPhone = new telPhone2();

        new Thread(() -> {
            telPhone.sms();
        }, "a").start();

        new Thread(() -> {
            telPhone.sms();
        }, "b").start();

    }
}

class telPhone2 {
    ReentrantLock lock = new ReentrantLock();

    public void sms() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
