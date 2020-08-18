package com.example.demo.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/6 14:37
 * @description：时间测试类
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        date();
        fun();
    }

    private static void date() {
        Date date = new Date();
        System.out.println(date);
    }

    private static void fun() {
        LocalDate date1 = LocalDate.now();
        System.out.println("data1 = " + date1);
        String s3 = date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("s3 = " + s3);
    }


}
