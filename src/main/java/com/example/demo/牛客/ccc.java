package com.example.demo.牛客;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/31 21:00
 * @description：
 */
public class ccc {
    public static void main(String[] args) {
        translateNum(12158);
    }

    public static int translateNum (int num) {
        String str = String.valueOf(num);
        String[] a = str.split("");
        int count = 1;
        for(int i = 0;i<a.length-1;i++){
            if(Integer.valueOf(a[i]+a[i+1])<25){
                System.out.println(a[i]+a[i+1]);
                count=count+1;
            }
        }
        System.out.println("count = "+count);
        return count;
    }

    public static String getABC(int num){
        String str = "0,1,2,3,4,5,6,,7,8,9,10";
        return "";
    }
}
