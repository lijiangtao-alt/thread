package com.company.singleton;

/**
 * @Description 饿汉式（静态常量）（可用）
 * @Author lijiangtao
 * @Date 2020/9/27 16:10
 * @Version 1.0
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
