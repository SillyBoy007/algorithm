package com.wxy.learn.practice.array.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  N数之和
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
    public static int[] twoSum(int[] a , int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <a.length ; i++) {
            map.put(a[i],i);

            int nums = target - a[i];

            while (map.get(nums) != null &&  map.get(nums) != i){
                return new int[]{map.get(nums),i};
            }
        }

        return null;
    }


    /**
     * 三数之和
     * @param a
     * @return
     */
    public static int [] threeSum(int[] a){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {

        }
    }



    public static void main(String[] args) {
        int [] a = {1,2,4,-1,5};

        System.out.println(Arrays.toString(twoSum(a,0)));
    }
}
