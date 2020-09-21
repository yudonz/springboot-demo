package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/9/8 10:16
 * @description：
 */
public class DistinctTest {
    private static List<Integer> list;

    private static void init() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(123);
            list.add(144);
            list.add(157);
            list.add(144);
            list.add(144);
            list.add(144);
        }
    }

    public static void main(String[] args) {
        init();
        distinct();
    }

    private static void distinct() {
        if (list != null) {
            System.out.println("distinct方法");
            list.stream().forEach(System.out::println);
            System.out.println("去重后");
            list.stream().distinct().forEach(System.out::println);
        }
    }


}
