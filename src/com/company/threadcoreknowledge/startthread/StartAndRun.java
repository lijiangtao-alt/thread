package com.company.threadcoreknowledge.startthread;

/**
 * @Description StartAndRun 的区别
 * @Author lijiangtao
 * @Date 2020/9/14 22:09
 * @Version 1.0
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
