package com.example.demo.牛客;

import java.util.ArrayList;

/**
 * @Author "ZHAO Yudong"
 * @Date 2020/8/30 22:36
 * @description：
 */
public class aaa {

    public static void main(String[] args) {

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
