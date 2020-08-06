package com.example.demo.test;


import org.apache.commons.lang.StringUtils;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/6 15:16
 * @description：StringUtils测试类
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        isEmpty();
        isBlank();
    }

    //return str == null || str.length() == 0;
    public static void isEmpty() {
        String str = null;
        boolean isEmpty = StringUtils.isEmpty(str);
        System.out.println(isEmpty);
    }

    //null || length() == 0 || 空白字符
    public static void isBlank() {
        String str = null;
        boolean isBlank = StringUtils.isBlank(str);
        System.out.println(isBlank);
    }


}
