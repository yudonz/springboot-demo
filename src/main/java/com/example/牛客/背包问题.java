package com.example.牛客;

import java.util.Scanner;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 11:55
 * @description：https://www.nowcoder.com/question/next?pid=20725618&qid=643390&tid=35894952 有为N件物品，它们的重量w分别是w1,w2,...,wn，
 * 它们的价值v分别是v1,v2,...,vn，每件物品数量有且仅有一个，
 * 现在给你个承重为M的背包，求背包里装入的物品具有的价值最大总和？
 * <p>
 * 输入描述:
 * 物品数量N=5件
 * 重量w分别是2 2 6 5 4
 * 价值v分别是6 3 5 4 6
 * 背包承重为M=10
 * <p>
 * 输出描述:
 * 背包内物品最大总和为15
 * <p>
 * 输入例子1:
 * 5
 * 10
 * 2 2 6 5 4
 * 6 3 5 4 6
 * <p>
 * 输出例子1:
 * 15
 */
public class 背包问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String str3 = in.nextLine();
        String str4 = in.nextLine();
        fun(str1, str2, str3, str4);
    }

    private static void fun(String str1, String str2, String str3, String str4) {
//        Map<Integer,Integer> map= new HashMap<>();
//        String[] k = str2.split(" ");
//        String[] v = str3.split(" ");
//        List<String> list = new ArrayList<>();
//        int kg = 0,kgg=Integer.valueOf(str4).intValue();
//        int vl = 0;
//        for (int i=0;i<Integer.valueOf(str1).intValue();i++){
//            if (kg<kgg){
//                if (!list.contains(k[i])){
//                    list.add(k[i]);
//                    vl+=vl[i];
//                }
//            }
//        }

    }
}
