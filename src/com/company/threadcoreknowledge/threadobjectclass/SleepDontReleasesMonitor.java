package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description     展示线程sleep的时候不释放synchronize 的 monitor，
 * 等sleep时间到了之后，正常结束才释放锁
 * @Author lijiangtao
 * @Date 2020/9/17 22:15
 * @Version 1.0
 */
public class SleepDontReleasesMonitor implements Runnable{
    public static void main(String[] args) {
        SleepDontReleasesMonitor sleepDontReleasesMonitor = new SleepDontReleasesMonitor();
        new Thread(sleepDontReleasesMonitor).start();
        new Thread(sleepDontReleasesMonitor).start();
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"退出了同步代码块");

    }
}
