package com.example.demo.test;

import com.example.demo.entity.People;
import org.springframework.beans.BeanUtils;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/24 16:31
 * @description：
 */
public class BeanUtilsTest {
    public static void main(String[] args) {
        People p1 = new People();
        p1.setId(1);
        p1.setName("zz");

        People p2 = new People();

        BeanUtils.copyProperties(p2, p1);


        System.out.println(p2);

    }
}
