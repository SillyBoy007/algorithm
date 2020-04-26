package com.wxy.learn.algorithm.practice.link.leetcode;

import com.wxy.learn.datastructure.linearlist.linklist.SingleList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * @author wangxiayun
 * @since 2020/4/2
 **/
public class CycleLink {
    /**
     * 一.哈希表(时间O(n) 空间O(n))
     * 利用Haset存储node，遍历一边完成后若是环形链表会继续遍历，则set集合中若已经包含该node，则为环形链表
     *
     * @param node
     * @return
     */
    public boolean hasCycle(SingleList.Node node) {
        Set<SingleList.Node> nodeSet = new HashSet<>();
        while (node != null) {
            if (nodeSet.contains(node)) {
                return true;
            } else {
                nodeSet.add(node);
            }

            node = node.next;
        }
        return false;
    }

    /**
     * 二.双指针 （时间复杂度(On) 空间复杂度(On)）
     *
     * @param node
     * @return
     */
    public boolean hasCycle2(SingleList.Node node) {
        if (node == null) {
            return false;
        }
        SingleList.Node fast = node.next;
        SingleList.Node slow = node;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
