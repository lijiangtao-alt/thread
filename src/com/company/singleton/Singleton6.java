package com.company.singleton;

/**
 * @Description 双重检查模式（推荐面试使用）
 * @Author lijiangtao
 * @Date 2020/9/27 16:35
 * @Version 1.0
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6(){

    }

    public  static Singleton6 getInstance() {
        if (instance == null){
            //如果两个线程同时到达这一行，那么就会创建两个实例，就不是单例了
            synchronized (Singleton6.class){
                //看上去解决了问题，但其实并没有，当第一个线程释放了锁以后，第二个还是会重置这个实例
                if (instance == null){
                    //再来一次判断
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
