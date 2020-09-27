package com.company.singleton;

/**
 * @Description 懒汉式（线程不安全）
 * @Author lijiangtao
 * @Date 2020/9/27 16:35
 * @Version 1.0
 */
public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){

    }

    public static Singleton3 getInstance() {
        if (instance == null){      //如果两个线程同时到达这一行，那么就会创建两个实例，就不是单例了
            instance = new Singleton3();
        }
        return instance;
    }
}
