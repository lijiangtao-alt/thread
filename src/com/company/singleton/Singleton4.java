package com.company.singleton;

/**
 * @Description 懒汉式（线程安全）（但是不推荐）
 * @Author lijiangtao
 * @Date 2020/9/27 16:35
 * @Version 1.0
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){

    }

    public synchronized static Singleton4 getInstance() {
        //性能问题，两个线程同时到来，不能及时响应
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
