package com.wxy.learn.algorithm.practice.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangxiayun
 * @since 2020/3/25
 **/
@Slf4j
public class BaseArray {
    /**
     * 数组实际大小
     */
    protected int size;

    /**
     * 数组容积
     */
    protected int capacity;
    /**
     * 数组容器
     */
    protected int[] arr;

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != capacity - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        log.info("arr:{},capacity:{},size:{}", sb.toString(), this.capacity, this.size);
    }
}
