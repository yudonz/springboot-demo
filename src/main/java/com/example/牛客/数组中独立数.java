package com.example.牛客;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找出数组中，个数为一的那个数字
 */
public class 数组中独立数 {
    public static void main(String[] args) {
        int[] a={3,2,2};
        int i = uniqueAward(a);
        System.out.println(i);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int uniqueAward(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // write code here
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }
        return 0;
    }

}
