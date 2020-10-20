package com.liwncy.onedemo.leetcode;

/**
 * 链表
 * Definition for singly-linked list.
 *
 * @author: Liwncy
 * @date: 2020-10-19 15:48
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
