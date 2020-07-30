package com.wxy.learn.practice.array.solution;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * @author wangxiayun
 * @since 2020/7/29
 **/
public class MajorityElementSolution {

    /**
     * 1.分组统计法 T(On) S(O1)
     * @param nums
     * @return
     */
    public int solution(int [] nums){
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int limit = nums.length / 2;
        for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
            if (limit < entry.getValue()){
                return entry.getKey();
            }
        }

        return -1;
    }


    /**
     * 2.摩尔投票法 T(On) S(O1)
     */

    public int solution2(int [] nums){
        int ticket = 1;
        int vote = nums [0];

        for (int i = 1; i < nums.length; i++) {
            if (vote == nums[i]){
                ticket ++ ;
            }else {
                ticket --;
            }

            if (ticket <= 0){
                vote = nums[i];
                ticket = 1;
            }
        }

        return vote;
    }
}
