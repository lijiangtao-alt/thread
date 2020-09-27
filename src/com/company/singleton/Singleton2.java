package com.company.singleton;

/**
 * @Description 饿汉式（静态代码块）（可用）
 * @Author lijiangtao
 * @Date 2020/9/27 16:10
 * @Version 1.0
 */
public class Singleton2 {
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
