package com.company.singleton;

/**
 * @Description 懒汉式（线程不安全）（但是不推荐）
 * @Author lijiangtao
 * @Date 2020/9/27 16:35
 * @Version 1.0
 */
public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){

    }

    public  static Singleton5 getInstance() {
        if (instance == null){
            //如果两个线程同时到达这一行，那么就会创建两个实例，就不是单例了
            synchronized (Singleton5.class){
                //看上去解决了问题，但其实并没有，当第一个线程释放了锁以后，第二个还是会重置这个实例
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
