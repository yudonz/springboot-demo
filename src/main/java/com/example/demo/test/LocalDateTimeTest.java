package com.example.demo.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/6 14:37
 * @description：时间测试类
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s3 = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(s3);
    }
}
