package com.example.牛客;

import java.util.Scanner;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 11:18
 * @description：
 */
public class 英文句子单词翻转 {

    /**
     * 原地翻转句子中单词的顺序，但单词内字符的顺序不变。要求：空间复杂度O(1)，时间复杂度O(n)。
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String s1 = retourer(str);
        System.out.println(s1);
    }

    public static String retourer(String str) {
        String[] s = str.split(" ");
        StringBuilder s1 = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            s1.append(s[i] + " ");
        }
        //System.out.println(s1);
        return s1.toString();
    }
}
