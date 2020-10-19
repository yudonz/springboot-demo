package com.example.test;


import com.alibaba.fastjson.JSON;
import com.example.entity.People;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ZHAO Yudong
 * @Date 2020/9/9 17:00
 * @description：
 */
public class PeekTest {
    private static List<People> list;

    private static void init() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
            list.add(new People(1, "张三", LocalDateTime.now()));
        }
    }

    public static void main(String[] args) {
        init();
        peek();
    }

    private static void peek() {
        List<People> collect = list.stream().peek(a -> {
            a.setId(2);
            a.setName("李四");
        }).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }


}
