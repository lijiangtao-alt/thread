package com.company.threadcoreknowledge.stopthreads;

/**
 * @Description 带有 sleep 中断线程的写法
 * @Author lijiangtao
 * @Date 2020/9/15 21:48
 * @Version 1.0
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =() ->{
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(500);
        thread.interrupt();
    }
}
