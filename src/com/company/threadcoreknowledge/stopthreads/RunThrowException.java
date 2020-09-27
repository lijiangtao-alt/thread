package com.company.threadcoreknowledge.stopthreads;

/**
 * @Description  run 无法抛出 checked Exception，只能用 try/catch
 * @Author lijiangtao
 * @Date 2020/9/15 22:45
 * @Version 1.0
 */
public class RunThrowException {
    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
