package com.company.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author lijiangtao
 * @Date 2020/9/28 22:00
 * @Version 1.0
 */
public class Lock {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{
            phone.sendMsg();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }).start();
    }
}
class Phone{

    public synchronized void sendMsg(){
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

}
