package com.liwncy.onedemo.leetcode;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1290 👎 0


/**
 * [14]最长公共前缀
 *
 * @author: Liwncy
 * @date: 2020-09-30 09:39
 **/
public class Leet0014 {
    public static void main(String[] args) {
        Leet0014 leet = new Leet0014();
        String[] strs = new String[]{"fleower", "fleow", "fleight"};
        strs = new String[]{"aa","a"};
        System.out.println(leet.longestCommonPrefix11(strs));
    }

    /**
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        String commonStr = "";
        if (strs == null || strs.length == 0) {
            return "";
        }
        commonStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cstr = "";
            for (int j = 0; j < Math.min(commonStr.length(), strs[i].length()); j++) {
                if (commonStr.charAt(j) == strs[i].charAt(j)) {
                    cstr += strs[i].charAt(j);
                } else {
                    break;
                }
            }
            commonStr = cstr;
        }
        return commonStr;
    }
    // 调优:字符串累加改为计数截取字符串;
    public String longestCommonPrefix11(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        String cstr = strs[0];
        for (int i = 1; i < len; i++) {
            int length = Math.min(cstr.length(), strs[i].length());
            int j = 0;
            for (; j < length; j++) {
                if (cstr.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            cstr = cstr.substring(0, j);
        }
        return cstr;
    }
}
