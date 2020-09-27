package com.company.threadcoreknowledge.wrongways;

/**
 * @Description 匿名内部类
 * @Author lijiangtao
 * @Date 2020/9/14 21:35
 * @Version 1.0
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
