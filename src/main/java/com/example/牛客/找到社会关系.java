package com.example.牛客;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 好友具有传递性，找到社会群体的个数
 */
public class 找到社会关系 {

    public static void main(String[] args) {

        int[][] a = new int[3][4];
        System.out.println(a.length);
        System.out.println(a[0].length);

    }

    public static int findFriendNum(int[][] M) {
        // write code here
        int n = M.length;
        int m = M[0].length;
        int count = n;
        String[] a=new String[n];
        Set set = new HashSet<>();
        Map<Set,Set> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                if (j == i) {
                } else if (M[i][j] == 1) {
                   count--;
                } else if (M[i][j] == 0) {

                }
            }
        }

        return count;
    }
}
