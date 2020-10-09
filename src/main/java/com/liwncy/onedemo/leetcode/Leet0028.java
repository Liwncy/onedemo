package com.liwncy.onedemo.leetcode;
//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
// 👍 590 👎 0

/**
 * [28]实现strStr()
 *
 * @author: Liwncy
 * @date: 2020-10-09 15:24
 **/
public class Leet0028 {
    public static void main(String[] args) {
        Leet0028 leet = new Leet0028();
        System.out.println(leet.strStr11("hello" , "ll"));
        System.out.println(leet.strStr11("aaa" , "aaaa"));
        System.out.println(leet.strStr11("" , ""));
    }

    /**
     * 如果第一个匹配,遍历needle下一个类推,遍历结束返回i
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        if (nl == 0) {
            return 0;
        }
        for (int i = 0; i < hl; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                for (; j < nl; j++) {
                    if (i + j >= hl) {
                        break;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nl) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 优化:减少循环次数(i<=hl-nl);初始j=1;
    public int strStr11(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (nl == 0) {
            return 0;
        }
        for (int i = 0; i <= hl - nl; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                for (; j < nl; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nl) {
                    return i;
                }
            }
        }
        return -1;
    }
}
