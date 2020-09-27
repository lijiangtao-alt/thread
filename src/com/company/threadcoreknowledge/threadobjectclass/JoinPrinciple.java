package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description 通过分析join 源码，分析出join 的代替写法
 * @Author lijiangtao
 * @Date 2020/9/18 14:57
 * @Version 1.0
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        });

        thread.start();
        System.out.println("开始等待子线程执行完毕");
//        thread.join();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
