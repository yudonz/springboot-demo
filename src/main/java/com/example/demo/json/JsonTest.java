package com.example.demo.json;

import net.sf.json.JSONArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/17 10:22
 * @description：
 */
public class JsonTest {
    private static List<String> si = Arrays.asList("1,2,3,4,5");

    public static void main(String[] args) {

//        fin();
        fun3();
    }

    private static void fun3() {
        String s = "1,2,3,4,5";
        System.out.println(s);
        Set<Integer> set = Arrays.stream(s.split(",")).map(a -> Integer.valueOf(a)).collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void fin() {
        Set<Integer> set = new HashSet<>();
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(16);
        if (set.contains(12)) {
            set.remove(Integer.valueOf(11));
        }
        JSONArray json = JSONArray.fromObject(set);
        System.out.println(json);
    }


}
