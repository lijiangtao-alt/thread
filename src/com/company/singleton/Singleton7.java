package com.company.singleton;

/**
 * @Description 静态内部类方式，可用
 * @Author lijiangtao
 * @Date 2020/9/27 16:35
 * @Version 1.0
 */
public class Singleton7 {


    private Singleton7(){

    }

    private static class SingletonInstance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public  static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
