package com.company.jmm;

import com.company.singleton.Singleton8;

/**
 * @Description 演示可见性带来的问题, volatile可以强制每一次读取到的值都是最新的
 * * 四种结果：
 * * ExecutionResult{a=3, b=2} write1 -> read -> write2
 * * ExecutionResult{a=3, b=3} write1 -> write2 -> read
 * * ExecutionResult{a=1, b=2} read -> write1 -> write2
 * * ExecutionResult{a=1, b=3} 发生可见性问题
 * @Author lijiangtao
 * @Date 2020/9/24 20:37
 * @Version 1.0
 */
public class FieldVisibility {
    volatile int a = 1;
    volatile int b = 2;

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b = " + b + ",a = " + a);
    }

    public static void main(String[] args) {

//        Singleton8.INSTANCE.whatever();

        while (true) {
            FieldVisibility test = new FieldVisibility();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }

}
