package com.company.threadcoreknowledge.stopthreads;

/**
 * @Description run 方法内没有 sleep 或者 wait 时停止线程
 * @Author lijiangtao
 * @Date 2020/9/15 21:36
 * @Version 1.0
 */
public class RightWayStopThread implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务结束！");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThread());
        thread.start();
        thread.sleep(2000);
        thread.interrupt();
    }
}
