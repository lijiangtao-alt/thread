package com.company.threadcoreknowledge.uncaughtexception;

/**
 * @Description 使用自己写的UncaughtExceptionHandler
 * @Author lijiangtao
 * @Date 2020/9/18 21:46
 * @Version 1.0
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler
                (new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();

    }

    @Override
    public void run() {
        throw new RuntimeException();

    }
}
