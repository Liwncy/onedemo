package com.liwncy.onedemo.leetcode;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1290 👎 0


/**
 * 合并两个有序链表
 *
 * @author: Liwncy
 * @date: 2020-09-30 14:46
 **/
public class Leet0021 {
    public static void main(String[] args) {
        Leet0021 leet = new Leet0021();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode q1 = leet.mergeTwoLists(l1, l2);
        ListNode q2 = leet.mergeTwoLists1(l1, l2);
        System.out.println(q1);
    }

    /**
     * 非递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode ln = listNode;
        while (l1!=null || l2!=null){
            if (l1 == null) {
                ln.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                ln.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                ln.next = new ListNode(l2.val);
                l2 = l2.next;
            }else {
                ln.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ln = ln.next;
        }
        return listNode.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            return new ListNode(l1.val, mergeTwoLists(l2,l1.next));
        }else {
            return new ListNode(l2.val, mergeTwoLists(l1,l2.next));
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
