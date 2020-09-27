package com.company.background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description     发布溢出
 * @Author lijiangtao
 * @Date 2020/9/19 16:33
 * @Version 1.0
 */
public class MultiThreadError3 {
    private Map<String,String> states;

    public MultiThreadError3() {
        states = new HashMap<>();
        states.put("1","shanghai");
        states.put("2","beijing");
        states.put("3","nanjing");
        states.put("4","xian");
    }

    public Map<String,String> getStates(){
        return states;
    }
    public Map<String,String> getStatesImproved(){
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadError3 multiThreadError3 = new MultiThreadError3();
        Map<String, String> states = multiThreadError3.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));

        System.out.println(multiThreadError3.getStatesImproved().get("1"));
        multiThreadError3.getStatesImproved().remove("1");
        System.out.println(multiThreadError3.getStatesImproved().get("1"));

    }
}
