package com.wxy.learn.practice.link.leetcode;

import com.wxy.learn.datastructure.linearlist.linklist.SingleList;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. 链表的中间结点(Easy)
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 *
 * @author wxy
 * @since 2020-12-24
 */
public class MiddleNode {


    /**
     * Solution1: 单指针法
     * T: O(n)
     * S: O(1)
     *
     * @param head
     * @return
     */
    public SingleList.Node middleNode1(SingleList.Node head) {
        SingleList.Node cur = head;
        int length = this.getLength(cur);

        cur = head;
        for (int i = 0; i < length / 2; i++) {
            cur = cur.next;
        }

        return cur;
    }

    /**
     * Solution2: 数组
     *
     * T: O(n)
     * S: O(n)
     * @param head
     * @return
     */
    public SingleList.Node middleNode2(SingleList.Node head) {
        List<SingleList.Node> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        return list.get(list.size()/2);

    }


    /**
     * Solution3: 快慢指针
     *
     * T:O(n)
     * S:O(1)
     * @param head
     * @return
     */
    public SingleList.Node middleNode3(SingleList.Node head) {
        SingleList.Node fast = head;
        SingleList.Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private int getLength(SingleList.Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
