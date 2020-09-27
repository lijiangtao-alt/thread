package com.company.background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description     构造函数中新建线程
 * @Author lijiangtao
 * @Date 2020/9/21 19:57
 * @Version 1.0
 */
public class MultiThreadError6 {
    private Map<String,String> states;

    public MultiThreadError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1","shanghai");
                states.put("2","beijing");
                states.put("3","nanjing");
                states.put("4","xian");
            }
        }).start();

    }

    public Map<String,String> getStates(){
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadError6 multiThreadError6 = new MultiThreadError6();
        Thread.sleep(1000);
        System.out.println(multiThreadError6.getStates().get("1"));
    }
}
