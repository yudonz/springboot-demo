package com.example.牛客;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 11:30
 * @description：https://www.nowcoder.com/question/next?pid=20725618&qid=643389&tid=35894952 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
 * <p>
 * 输入描述: 一行输入，数组中的数字用逗号隔开。例如：
 * <p>
 * 输入为： 32,231  则表示数组{32, 231}
 * 输出描述: 直接输出最小数字即可，如示例题目中，输出为：23132
 * <p>
 * 输入例子1: 32,231
 * 输出例子1: 23132
 */
public class 数组排成最小的数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        fun(str);
    }

    public static void fun(String string) {
        String[] split = string.split(",");
        List<String> strings = Arrays.asList(split);
        Collections.sort(strings, (o1, o2) -> {
            return (o1 + o2.substring(0, 1)).compareTo(o2 + o1.substring(0, 1));
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    //测试用例 3,32,321
}
