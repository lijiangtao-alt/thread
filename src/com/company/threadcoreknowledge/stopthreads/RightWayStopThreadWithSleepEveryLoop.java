package com.company.threadcoreknowledge.stopthreads;

/**
 * @Description 如果在执行过程中，每次循环都会调用sleep 或者 wait 方法,那么就不需要每次都检测是否中断
 * @Author lijiangtao
 * @Date 2020/9/15 22:03
 * @Version 1.0
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =() ->{
            int num = 0;
            try {
                while (num <= 10000 ) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
