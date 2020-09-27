package com.company.threadcoreknowledge.createthreads;

/**
 * @Description 用runnable方式创建线程
 * @Author lijiangtao
 * @Date 2020/9/11 19:21
 * @Version 1.0
 */
public class RunnableStyle implements Runnable{
    public static void main(String[] args) {
         new Thread(new RunnableStyle()).start();
    }

    @Override
    public void run() {
        System.out.println("用runnable方式创建线程");
    }
}
