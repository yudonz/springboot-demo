package com.example.test;

import com.example.entity.People;

import java.lang.reflect.Field;

/**
 * @Author ZHAO Yudong
 * @Date 2020/10/15 13:46
 * @description：
 */
public class 反射Test {
    public static void main(String[] args) throws Exception {
        People people = new People();
        people.setId(1);
        people.setName("张三");
        fun(people);
    }

    private static void fun(Object... params) throws Exception {
        System.out.println(params[0]);
        Class<?> paramtertypeClass = People.class;
        //反射
        Field declaredField = paramtertypeClass.getDeclaredField("name");
        //暴力访问
        declaredField.setAccessible(true);
        Object o = declaredField.get(params[0]);
        System.out.println("object = " + o);
    }


}
