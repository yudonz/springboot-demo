package com.example.demo.test;

import com.example.demo.entity.People;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/9/10 18:40
 * @description：
 */
public class NullTest {

    private static List<People> list;

    private static void init() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new People(null, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(null, "张三", LocalDateTime.now()));
        }
    }

    public static void main(String[] args) {
        init();
        if (list.get(0).getId().equals("1")) {
            System.out.println("1111");
        }

    }

}
