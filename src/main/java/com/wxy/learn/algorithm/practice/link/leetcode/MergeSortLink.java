package com.wxy.learn.algorithm.practice.link.leetcode;

import com.wxy.learn.algorithm.linearlist.linklist.SingleList;
import com.wxy.learn.algorithm.practice.link.LinkList;

import java.util.PriorityQueue;


/**
 * 合并K个排序链表
 *
 * @author wangxiayun
 * @since 2020/4/2
 **/
public class MergeSortLink {

    /**
     * 一.优先级队列(堆)(时间(On*logn) 空间(On))
     *
     */
    public static SingleList.Node mergeKLists(SingleList.Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<SingleList.Node> queue = new PriorityQueue<>(nodes.length, (o1, o2) -> {
            if (o1.data < o2.data) {
                return -1;
            } else if (o1.data == o2.data) {
                return 0;
            }
            return 1;
        });

        SingleList.Node dummy = new SingleList.Node(1, null);
        SingleList.Node p = dummy;

        for (SingleList.Node node : nodes) {
            if (node != null) {
                queue.add(node);
            }
        }


        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;

    }


    /**
     * 二.分治思想
     *
     * @return
     */
    public static SingleList.Node mergekLinkList(SingleList.Node[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        return merge(nodes, 0, nodes.length - 1);
    }

    private static SingleList.Node merge(SingleList.Node[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        SingleList.Node l1 = merge(lists, left, mid);
        SingleList.Node l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private static SingleList.Node mergeTwoLists(SingleList.Node l1, SingleList.Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        LinkList linkArray = new LinkList();
        linkArray.insertTail(1);
        linkArray.insertTail(3);
        linkArray.insertTail(5);
        linkArray.insertToHead(0);
//        linkArray.deleteByNode(linkArray.findByIndex(1));
//        linkArray.deleteByValue(2);

        //   linkArray.printAll();
        // linkArray.printNode(linkArray.inverseLink(linkArray.findByIndex(0)));


        LinkList linkArray2 = new LinkList();
        linkArray2.insertTail(2);
        linkArray2.insertTail(4);
        linkArray2.insertTail(6);


        SingleList.Node[] nodes = new SingleList.Node[2];
        nodes[0] = linkArray.findByIndex(0);
        nodes[1] = linkArray2.findByIndex(0);

        SingleList.Node node = MergeSortLink.mergeKLists(nodes);
        linkArray.printNode(node);

    }
}
