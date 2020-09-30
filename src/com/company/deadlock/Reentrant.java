package com.company.deadlock;

/**
 * @Description 什么是可重入锁
 * @Author lijiangtao
 * @Date 2020/9/30 14:04
 * @Version 1.0
 */
public class Reentrant {
    public static void main(String[] args) {
        telPhone telPhone = new telPhone();

        new Thread(()->{
            telPhone.sms();
        },"a").start();

        new Thread(()->{
            telPhone.sms();
        },"b").start();

    }
}
class telPhone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+" sms");
        call();
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+" call");
    }
}
