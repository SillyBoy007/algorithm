package com.wxy.learn.algorithm.practice.array.leetcode;

import java.util.*;


/**
 * 求众数
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class ModeMath {

    /**
     * 变型: 利用hash map求众数，数组中元素个数最多的数
     *
     * @param a
     * @return
     */
    public static int hashMode(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>(a.length);
        /**
         *  以value为key，求出所有值出现次数
         */
        for (int j = 0; j < a.length; j++) {
            int b = 1;
            if (map.containsKey(a[j])) {
                map.put(a[j], map.get(a[j]) + b);
            } else {
                map.put(a[j], +b);
            }
        }

        /**
         * 找出value最大的数
         */
        Iterator<Map.Entry<Integer, Integer>> itor = map.entrySet().iterator();
        int n = 0;
        int ret = 0;
        while (itor.hasNext()) {
            Map.Entry<Integer, Integer> next = itor.next();
            Integer value = next.getValue();
            Integer key = next.getKey();
            if (value > n) {
                n = value;
                ret = key;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] a = {1,7,2,7,3,7,4,7,5,7,7};
        System.out.println(hashMode(a));
    }
}
