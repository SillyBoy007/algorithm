package com.wxy.learn.practice.array.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * N数之和
 *
 * @author wangxiayun
 * @since 2020/7/30
 **/
public class NumSumSolution {

    /**
     * 两数之和 T(On) S（On）
     *
     * @param a
     * @param target
     * @return
     */
    public static int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);

            int nums = target - a[i];

            while (map.get(nums) != null && map.get(nums) != i) {
                return new int[]{map.get(nums), i};
            }
        }

        return null;
    }


    /**
     * 三数之和 T(On) S(On)
     *
     * @param a
     * @return
     */
    public static int[] threeSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }

        for (int j = 1; j < a.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int num = target - a[j] - a[i];
                if (map.get(num) != null && map.get(num) != i &&  map.get(num) != j) {
                    return new int[]{map.get(num),i,j};
                }

            }
        }

        return null;

    }


    public static void main(String[] args) {
        int[] a = {1, 2, 4, -3, 5};

        System.out.println(Arrays.toString(threeSum(a, 0)));
    }
}
