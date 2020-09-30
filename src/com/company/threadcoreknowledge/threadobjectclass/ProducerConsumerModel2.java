package com.company.threadcoreknowledge.threadobjectclass;

/**
 * 线程之间通信，生产者消费者问题，等待唤醒，等待通知
 * 线程之间交替执行， A  B 操作同一个变量，  num = 0
 * A  num+1
 * B  num-1
 * if 判断只会循环一次，采用 while 循环
 *
 */
public class ProducerConsumerModel2 {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}

// 等待，业务，通知  三步走
class Data { //数字 ，资源类
    private int number = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            //等待
            this.wait();
        }
        //业务
        number++;
        System.out.println(Thread.currentThread().getName()+" : "+number);
        //通知
        this.notifyAll();
    }

    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            //等待
            this.wait();
        }
        //业务
        number--;
        System.out.println(Thread.currentThread().getName()+" : "+number);
        //通知
        this.notifyAll();
    }

}
