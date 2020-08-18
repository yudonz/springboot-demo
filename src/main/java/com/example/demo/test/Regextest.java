package com.example.demo.test;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/17 18:15
 * @description：
 */
public class Regextest {
    public static void main(String[] args) {
//        fun();
//        fun2();
        fun3();
    }

    private static void fun3() {
        String phone = "021-69105516";
        if (phone.matches("^[0][1-9]{2,3}-[0-9]{5,10}$")) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }

    private static void fun2() {
        String phone = "12301721591";
        if (phone.matches("[1][3,4,5,7,8][0-9]{9}$")) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }

    private static void fun() {
        String name = "赵赵赵赵赵赵";
        if (name.matches("[\u4e00-\u9fa5]{0,8}")) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }
}
