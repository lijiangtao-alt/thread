package com.company.threadcoreknowledge.wrongways;

/**
 * @Description
 * @Author lijiangtao
 * @Date 2020/9/14 21:39
 * @Version 1.0
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
