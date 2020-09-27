package com.company.threadcoreknowledge.stopthreads.volatiledemo;


/**
 * @Description 演示volatile的局限1：看似可行
 * @Author lijiangtao
 * @Date 2020/9/16 20:42
 * @Version 1.0
 */
public class WrongWayVolatile implements Runnable{
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num =0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.canceled = true;
    }
}
