package com.example.test;


import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/6 15:16
 * @description：StringUtils测试类
 */
public class StringUtilsTest {
    public static void main(String[] args) {
//        isEmpty();
//        isBlank();
//        isNumeric();
//        isNumericSpace();

        join();
    }

    private static void join() {
        String name = "ni   hao";
        if (!StringUtils.isBlank(name)) {
            //name = name.replaceAll("\\s",",");
            String[] s = name.split(" ");
            String collect = Arrays.stream(s).filter(a -> !StringUtils.isBlank(a)).collect(Collectors.joining("|"));
            System.out.println("collect = " + collect);
            System.out.println(Arrays.toString(s));
            if (s.length == 1) {
                name = s[0].trim();
            } else {
                name = StringUtils.join(s, "|");
            }
        }
        System.out.println(name);
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
