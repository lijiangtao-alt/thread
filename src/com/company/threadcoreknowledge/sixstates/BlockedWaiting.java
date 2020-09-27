package com.company.threadcoreknowledge.sixstates;

/**
 * @Description
 * @Author lijiangtao
 * @Date 2020/9/17 10:59
 * @Version 1.0
 */
public class BlockedWaiting implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        BlockedWaiting runnable = new BlockedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread.sleep(5);

        Thread thread2 = new Thread(runnable);
        thread2.start();
        //打印出TIMED_WAITING状态，因为正在执行Thread.sleep(1000)
        System.out.println(thread1.getState());
        //打印出BLOCKED，因为thread2想拿到syn的锁，却拿不到
        System.out.println(thread2.getState());

        Thread.sleep(1300);
        //打印出WAITING状态，因为执行了wait
        System.out.println(thread1.getState());

    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
