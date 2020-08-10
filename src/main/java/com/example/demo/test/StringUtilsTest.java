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
        isNumeric();
        isNumericSpace();
    }

    //return str == null || str.length() == 0;
    public static void isEmpty() {
        String str = null;
        boolean isEmpty = StringUtils.isEmpty(str);
        System.out.println(isEmpty);
    }

    //if the String is null, empty or whitespace
    public static void isBlank() {
        String str = null;
        boolean isBlank = StringUtils.isBlank(str);
        System.out.println(isBlank);
    }

    //if only contains digits, and is non-null
    public static void isNumeric() {
        String str = "";
        boolean isNumeric = StringUtils.isNumeric(str);
        System.out.println(isNumeric);
    }

    //if only contains digits or space, and is non-null
    public static void isNumericSpace() {
        String str = "1 2";
        boolean isNumeric = StringUtils.isNumericSpace(str);
        System.out.println(isNumeric);
    }


}
