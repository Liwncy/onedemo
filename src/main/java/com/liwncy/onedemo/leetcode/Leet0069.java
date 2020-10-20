package com.liwncy.onedemo.leetcode;
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 524 👎 0

/**
 * [69]x的平方根
 *
 * @author: Liwncy
 * @date: 2020-10-15 16:56
 **/
public class Leet0069 {
    public static void main(String[] args) {
        Leet0069 leet = new Leet0069();
        System.out.println(leet.mySqrt(0));
        System.out.println(leet.mySqrt(1));
        System.out.println(leet.mySqrt(2));
        System.out.println(leet.mySqrt(4));
        System.out.println(leet.mySqrt(16));
        System.out.println(leet.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        long middle;
        while (left + 1 <= right) {
            middle = (left + right) / 2;
            if (x / middle >= middle && x / (middle + 1) < (middle + 1)) {
                return (int) middle;
            } else if (x / middle > middle) {
                left = (int) middle;
            } else {
                right = (int) middle;
            }
        }
        return left;
    }
    /**
     * 1,(int) Math.sqrt(x);
     */
}
