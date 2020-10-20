package com.liwncy.onedemo.leetcode;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
public class Leet0002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode q1 = addTwoNumbers1(l1, l2);
        ListNode q2 = addTwoNumbers2(l1, l2);
        System.out.println(q1);
    }
    // 非递归
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 生成ListNode链表对象，链表的值为0，没有指向的节点
        ListNode sumListNode = new ListNode(0);
        ListNode listNode = sumListNode;
        // 定义进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //最后一位的进位，如果有进位，把进位放到下一个链表里
        if (carry != 0) {
            listNode.next = new ListNode(carry);
        }
        return sumListNode.next;
    }

    // 递归解
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode sumListNode = addDigit(l1, l2, 0);
        return sumListNode;
    }

    public static ListNode addDigit(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        ListNode sumListNode;

        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;

        int sum = x + y + carry;
        carry = sum / 10;
        sumListNode = new ListNode(sum % 10);
        sumListNode.next = addDigit(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);

        return sumListNode;
    }

}
