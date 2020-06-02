package com.wxy.learn.algorithm.practice.sort;

/**
 * X的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author wxy
 * @since 2020-06-02
 */
public class Sqrt {
    /**
     * A1：袖珍计算器法  T(On) S(O1)
     *
     * @param x
     * @return
     */
    public static int sqrt(int x) {
        int exp = (int) Math.exp(0.5 * Math.log(x));
        return (exp + 1) * (exp + 1) <= x ? exp + 1 : exp;
    }


    /**
     * A2：二分查找法 T(Ologn) S(O1)
     * 由于小数部分要舍弃，所以要满足k^2 <= x
     *
     * @param x
     * @return
     */
    public static int sqrt2(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            }else if (mid * mid <= x){
                ans = mid;
                l = mid+1;
            }
        }

        return ans;
    }


}
