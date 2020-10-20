package com.liwncy.onedemo.leetcode;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 413 👎 0

import java.util.List;

/**
 * [83]删除排序链表中的重复元素
 *
 * @author: Liwncy
 * @date: 2020-10-19 15:45
 **/
public class Leet0083 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);

        Leet0083 leet = new Leet0083();
//        System.out.println(l1);
        System.out.println(leet.deleteDuplicates(l1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = head;
        ListNode nextNode = head;
        int n1 = head.val;
        while (nextNode.next != null){
            if(n1 != nextNode.val){
                listNode.next = nextNode;
                n1 = listNode.val;
            }
            nextNode = nextNode.next;
        }
        return listNode;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode listNode = head;
        while (listNode!=null&&listNode.next != null){
            if(listNode.val == listNode.next.val){
                listNode.next = listNode.next.next;
            }else {
                listNode = listNode.next;
            }
        }
        return head;
    }
}
