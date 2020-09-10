package com.example.demo.牛客;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/30 22:36
 * @description：
 */
public class bbb {
    public static void main(String[] args) {
        System.out.println(question(100,200));
    }

    public static int question (int a, int b) {
        // write code here
        int k=2;
        boolean e=false;
        boolean f=false;
        for(int i=2;i<=500;i++){
            int c = i+a;
            int d = i+b;
            if(Math.pow(c,0.5)-(int)Math.pow(c,0.5)==0.0  &&  Math.pow(d,0.5)-(int)Math.pow(d,0.5)==0.0){
                k=i;
            }

        }
        return (k);
    }
}

