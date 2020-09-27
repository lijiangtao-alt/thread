package com.company.threadcoreknowledge.createthreads;

/**
 * @Description 用Thread类实现线程
 * @Author lijiangtao
 * @Date 2020/9/11 19:25
 * @Version 1.0
 */
public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
