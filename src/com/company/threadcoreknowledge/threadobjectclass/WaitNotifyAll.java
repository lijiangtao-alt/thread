package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description 3个线程，线程1和2被阻塞，线程3去唤醒他们，
 * notify和notifyAll
 * start先执行，不代表线程先启动
 * @Author lijiangtao
 * @Date 2020/9/17 15:52
 * @Version 1.0
 */
public class WaitNotifyAll implements Runnable {
    private static final Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
//                    resourceA.notify();
                    System.out.println("ThreadC notified");
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(200);
        threadC.start();
    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " got resourceA lock");
            try {
                System.out.println(Thread.currentThread().getName() + " wait to start");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + " is waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
