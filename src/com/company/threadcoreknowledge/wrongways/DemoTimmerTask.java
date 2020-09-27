package com.company.threadcoreknowledge.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description 定时器创建线程
 * @Author lijiangtao
 * @Date 2020/9/14 21:30
 * @Version 1.0
 */
public class DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000,1000 );
    }
}
