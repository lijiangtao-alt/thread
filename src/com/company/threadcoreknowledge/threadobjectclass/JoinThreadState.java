package com.company.threadcoreknowledge.threadobjectclass;

/**
 * @Description     先join在 mainThread。getState（）
 * 通过debugger 看线程join 前后状态对比
 *
 * @Author lijiangtao
 * @Date 2020/9/18 14:07
 * @Version 1.0
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(mainThread.getState());
                    System.out.println("Thread0 运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行结束");
        thread.join();
        System.out.println("子线程运行结束");
    }
}
