package com.company.threadcoreknowledge.createthreads;

/**
 * @Description 同时使用 runnable 和 thread 两种方式
 * @Author lijiangtao
 * @Date 2020/9/11 19:50
 * @Version 1.0
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是来自 runnable ");
            }
        }) {
            @Override
            public void run() {
                System.out.println("这是来自 thread ");
            }
        }.start();
    }
}
