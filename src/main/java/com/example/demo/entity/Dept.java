package com.example.demo.entity;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/21 18:28
 * @description：
 */
public enum Dept {
    Artel0(0, "合作社 省");


    private Integer type;
    private String name;

    private Dept(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
