package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description 演示join注意语句的输出状态会变化
 * 因为新的线程加入了我们，所以我们等他执行完在出发
 *
 * @Author lijiangtao
 * @Date 2020/9/18 10:52
 * @Version 1.0
 */
public class Join {
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
        Thread thread2 = new Thread(new Runnable() {
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
        thread2.start();
        System.out.println("开始等待子线程执行完毕");
        thread.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
