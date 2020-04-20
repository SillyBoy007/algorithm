package com.wxy.learn.note.example;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯---全排列问题
 *
 *
 * @author wangxiayun
 * @since 2020/4/20
 **/
public class AllSort {
    private static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }


    // 路径:记录在track中
    // 选择条件：nums不存在track中的元素
    // 结束条件: nums所有元素都在track中
    public static void backtrack(int[] nums,LinkedList<Integer> track){
        //触发结束条件
        if (nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])){
                continue;
            }

            //做选择
            track.add(nums[i]);

            //进入下一层决策
            backtrack(nums,track);

            //取消选择

            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};

        System.out.println(permute(a));
    }
}
