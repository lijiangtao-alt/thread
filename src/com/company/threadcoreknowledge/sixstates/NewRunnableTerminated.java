package com.company.threadcoreknowledge.sixstates;

/**
 * @Description 展示线程的NEW ,RUNNABLE,TERMINATED状态，
 * 即使是正在运行状态，也是runnable状态，而不是running
 * @Author lijiangtao
 * @Date 2020/9/17 10:24
 * @Version 1.0
 */
public class NewRunnableTerminated implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出new的状态
        System.out.println(thread.getState());
        thread.start();
        //打印出runnable状态，
        System.out.println(thread.getState());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出runnable状态，即使是正在运行状态
        System.out.println(thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出terminated状态
        System.out.println(thread.getState());

    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
