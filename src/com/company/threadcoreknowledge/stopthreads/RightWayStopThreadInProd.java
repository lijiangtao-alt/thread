package com.company.threadcoreknowledge.stopthreads;

/**
 * @Description 最佳实践 ，catch了InterruptedException 之后的优先选择：在方法签名中抛出异常
 *              在run（）方法中就会强制 try/catch
 * @Author lijiangtao
 * @Date 2020/9/15 22:31
 * @Version 1.0
 */
public class RightWayStopThreadInProd implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("go!");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志，停止程序
                System.out.println("保存日志，正确的处理中断请求");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
