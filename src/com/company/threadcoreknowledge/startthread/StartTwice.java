package com.company.threadcoreknowledge.startthread;

/**
 * @Description 演示不能两次调用start方法，否则报错
 * @Author lijiangtao
 * @Date 2020/9/14 22:16
 * @Version 1.0
 */
public class StartTwice {
    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.start();
        thread.start();

    }
}
