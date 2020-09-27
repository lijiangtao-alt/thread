package com.company.background;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 第一种：运行结果出错，演示计数结果不准确（减少），找出具体出错的位置
 * @Author lijiangtao
 * @Date 2020/9/19 10:45
 * @Version 1.0
 */
public class MultiThreadError2 implements Runnable {
    int index = 0;
    static MultiThreadError2 instance = new MultiThreadError2();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    final boolean[] marked = new boolean[100000];

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面运行的结果" + instance.index);
        System.out.println("真正运行的次数" + realIndex.get());
        System.out.println("错误的次数" + wrongCount.get());

    }

    @Override
    public void run() {
//        while (index < 10000) {
//            index++;
//        }
        for (int i = 0; i < 10000; i++) {
            index++;
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index]) {
                    System.out.println("发生了错误" + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
