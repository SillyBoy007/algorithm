package com.wxy.learn.practice.link.leetcode;

import com.wxy.learn.datastructure.linearlist.linklist.SingleList;

import java.util.Stack;

/**
 * 19. 删除链表的倒数第N个节点(Mid)
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * @author wxy
 * @since 2020-12-23
 */
public class RemoveNthFromEnd {

    /**
     * Solution1: 统计链表长度
     * T: O(L) L为链表长度
     * S: O(1)
     * 先计算长度，在根据长度找出倒数第n个节点，将其
     * @param head
     * @param n
     * @return
     */
    public SingleList.Node removeNthFromEnd(SingleList.Node head, int n) {
        SingleList.Node dummy = new SingleList.Node(0, head);
        SingleList.Node cur = dummy;
        Integer length = getLength(head);
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        //dummy为哨兵节点
        return dummy.next;
    }

    /**
     * Solution2: 栈
     * T: O(n)
     * S: O(n)
     *
     * 利用栈的特性，对链表进行压栈，出栈，找出倒数第n个节点，将其引用指向下下个节点
     * @param head
     * @param n
     * @return
     */
    public SingleList.Node removeNthFromEnd2(SingleList.Node head, int n) {
        SingleList.Node dummy = new SingleList.Node(0, head);

        Stack<SingleList.Node> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        //peek()返回栈顶的值，与pop不同的是，不移除，只是单纯地返回值
        SingleList.Node prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }


    /**
     * Solution3: 快慢指针
     * T: O(n)
     * S: O(1)
     *
     * 当fast节点指向末尾的 NULL，当fast与slow之间相隔的元素个数为 n 时，
     * 那么删除掉slow的下一个指针就完成了要求
     *
     * @param head
     * @param n
     * @return
     */
    public SingleList.Node removeNthFromEnd3(SingleList.Node head, int n){

        SingleList.Node dummy = new SingleList.Node(-1,head);

        SingleList.Node fast = head;
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }

        SingleList.Node slow = head;

        SingleList.Node pre = dummy;
        while (fast.next != null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;

        return dummy.next;
    }

    public Integer getLength(SingleList.Node head) {
        int length = 0;
        while (null != head) {
            length++;
            head = head.next;
        }
        return length;
    }

}
