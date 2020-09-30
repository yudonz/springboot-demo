package com.example.demo.牛客;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Author "ZHAO Yudong"
 * @Date 2020/8/30 22:36
 * @description：
 */
public class aaa {

    public static void main(String[] args) {
        System.out.println(0 / Math.random());
        System.out.println(Math.round(-1.5));
        BigDecimal bigDecimal = new BigDecimal("1");
        System.out.println(bigDecimal);

    }

    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here

        ArrayList<String> str = values.get(0);
        for (ArrayList<String> list:values){
            str.retainAll(list);
        }
        return str;
    }
}
