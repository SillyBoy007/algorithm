package com.wxy.learn.algorithm.practice.link;

import com.wxy.learn.datastructure.linearlist.linklist.SingleList;

/**
 * @author wangxiayun
 * @since 2020/3/31
 **/
public class LinkList {
    private SingleList.Node head = null;

    public SingleList.Node findByValue(int value) {
        SingleList.Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public SingleList.Node findByIndex(int index) {
        SingleList.Node node = head;
        int pos = 0;
        while (node != null && pos != index) {
            node = node.next;
            pos++;
        }
        return node;
    }

    public void insertToHead(int value) {
        if (this.head == null) {
            this.head = new SingleList.Node(value, null);
            return;
        }
        this.head = new SingleList.Node(value, this.head);
    }

    public void insertTail(int value) {
        if (this.head == null) {
            this.head = new SingleList.Node(value, null);
            return;
        }
        SingleList.Node node = head;

        while (node.next != null) {
            node = node.next;
        }
        node.next = new SingleList.Node(value, null);
    }

    public void deleteByNode(SingleList.Node p) {
        if (p == null || head == null) {
            return;
        }
        SingleList.Node q = head;

        while (q != null && p != q.next) {
            q = q.next;
        }


        if (q != null) {
            q.next = q.next.next;
        }

    }

    public void deleteByValue(int value) {
        SingleList.Node q = this.head;
        while (q != null && q.next.data != value) {
            q = q.next;
        }

        if (q != null) {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        if (this.head == null) {
            return;
        }
        SingleList.Node node = this.head;
        while (node != null) {
            System.out.print(node.getData() + "   ");
            node = node.next;
        }

    }

    /**
     * 有头节点链表反转
     *
     * @param node
     * @return
     */
    public SingleList.Node inverseLinkList_head(SingleList.Node node) {
        SingleList.Node head = new SingleList.Node(999, null);
        head.next = node;

        SingleList.Node curr = node.next;
        node.next = null;

        SingleList.Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = head.next;
            head.next = curr;

            curr = next;
        }
        return head;
    }

    /**
     * 无头节点
     *
     * @param node
     * @return
     */
    public SingleList.Node inverseLink(SingleList.Node node) {
        SingleList.Node pre = null;
        SingleList.Node curr = node;
        while (curr != null) {
            SingleList.Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    /**
     * 检测环链表
     *
     * @param list
     * @return
     */
    public boolean checkCircle(SingleList.Node list) {
        if (list == null) {
            return false;
        }

        SingleList.Node fast = list.next;
        SingleList.Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个有序链表
     *
     * @return
     */
    public SingleList.Node mergeSortedLists(SingleList.Node l1, SingleList.Node l2) {
        //利用哨兵结点简化实现难度 技巧三
        SingleList.Node soldier = new SingleList.Node();
        SingleList.Node p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }


    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public SingleList.Node mergeTwoLists(SingleList.Node l1, SingleList.Node l2) {
        SingleList.Node pre = l1;
        SingleList.Node head = l1;
        while (l1 != null) {
            pre = l1;
            l1 = l1.next;
        }
        pre.next = l2;

        return head;
    }

    public void printNode(SingleList.Node node) {
        if (node == null) {
            return;
        }
        System.out.println();
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
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
        linkArray2.insertTail(6);
        linkArray2.insertTail(6);


        SingleList.Node node = linkArray.mergeTwoLists(linkArray.findByIndex(0), linkArray2.findByIndex(0));
        linkArray.printNode(node);
        SingleList.Node node2 = linkArray.mergeSortedLists(linkArray.findByIndex(0), linkArray2.findByIndex(0));
        linkArray.printNode(node2);
    }
}
