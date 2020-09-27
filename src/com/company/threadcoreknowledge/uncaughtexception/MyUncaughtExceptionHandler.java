package com.company.threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description 这是自己的MyUncaughtExceptionHandler
 * @Author lijiangtao
 * @Date 2020/9/18 21:31
 * @Version 1.0
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程终止了" + t.getName(), e);
        System.out.println(name + "捕获了异常" + t.getName() + "异常" );
    }
}
