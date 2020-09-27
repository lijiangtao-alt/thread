package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description 两个线程交替打印0~100的奇偶数，用synchronize关键字实现
 * @Author lijiangtao
 * @Date 2020/9/17 20:06
 * @Version 1.0
 */
public class WaitNotifyPrintOdd {

    private static int count;
    private static final Object lock = new Object();

    //新建两个线程
    //第一个只处理偶数，第二个只处理奇数(用位运算)
    //用synchronize相互通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
//                        if(count%2==0)
                        if ((count & 1) == 0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
//                        if(count%2==0)
                        if ((count & 1) == 1){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"奇数").start();
    }
}
