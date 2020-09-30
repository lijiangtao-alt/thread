package com.company.threadcoreknowledge.createthreads;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description     手动写一个线程池，七个参数
 * @Author lijiangtao
 * @Date 2020/9/29 10:59
 * @Version 1.0
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,                        //核心线程个数
                5,                   //线程池里面最大线程个数
                3,                      //等待的时间
                TimeUnit.SECONDS,                    //等待的时间，秒
                new LinkedBlockingDeque<>(3),//阻塞队列数
                Executors.defaultThreadFactory(),    //默认一般不动
                new ThreadPoolExecutor.AbortPolicy() //拒绝策略，等待队列也满了，就不处理了，抛出异常
        );

        try {
            //最大承载数，Deque + max
            //超过会抛异常 RejectedExecutionException
            for (int i = 1; i < 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

//        Lock lock = new ReentrantLock(true);

    }
}
