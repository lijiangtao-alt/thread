package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description     id从1开始，JVM运行起来之后我们自己创建的线程的id早已不是2
 * @Author lijiangtao
 * @Date 2020/9/18 15:52
 * @Version 1.0
 */
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的id："+Thread.currentThread().getId());
        System.out.println("子线程的id："+thread.getId());
    }

}
