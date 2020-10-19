package com.example.牛客;

import java.util.Scanner;

/*
链接：https://ac.nowcoder.com/acm/contest/6911/A
来源：牛客网

给你一个正整数n，重复进行以下操作：
1.如果n是奇数，令n=n−3
2.如果n是偶数，令n=n/2
重复上述直至n=0停止，请输出进行操作的次数，如果n永远无法变成零，输出-1
 */
public class 正整数操作 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        fun(num);
    }

    private static void fun(int n) {
        int i = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                n = n - 3;
                if (n < 0) {
                    i = -1;
                    break;
                }

            } else {
                n = n / 2;
            }
            i++;
        }
        System.out.println(i);
    }
}
