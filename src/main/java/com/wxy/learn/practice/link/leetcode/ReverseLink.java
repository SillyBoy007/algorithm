package com.wxy.learn.practice.link.leetcode;


import com.wxy.learn.datastructure.linearlist.linklist.SingleList;

import java.util.Stack;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author wxy
 * @since 2020-12-23
 */
public class ReverseLink {

    /**
     * Solution1: 栈
     * T: O(n)
     * S: O(n)
     * 使用栈数据结构对链表进行压栈和出栈
     *
     * @returna
     */
    public SingleList.Node reverseNodeByStack(SingleList.Node head) {
        Stack<SingleList.Node> stack = new Stack<>();
        //链表节点放入栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        SingleList.Node node = stack.pop();
        SingleList.Node dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            SingleList.Node tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }


    /**
     * Solution2: 双链表（迭代）
     * T: O(n)
     * S: O(1)
     * 创建一个新的链表，旧链表从head节点开始一个节点一个节点地引用到新的链表
     *
     * @return
     */
    public SingleList.Node reverseNodeByEach(SingleList.Node head){
        SingleList.Node prev = null;
        SingleList.Node curr = head;

        while (curr != null){
            SingleList.Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * Solution3: 递归
     * T: O(n)
     * S: O(n) 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层
     *
     * @param head
     * @return
     */
    public SingleList.Node reverseNodeByRecursion(SingleList.Node head){
       if (head == null ||  head.next == null){
           return head;
       }

        SingleList.Node node = reverseNodeByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
