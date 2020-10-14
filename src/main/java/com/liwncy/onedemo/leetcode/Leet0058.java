package com.liwncy.onedemo.leetcode;
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串
// 👍 246 👎 0

/**
 * [58]最后一个单词的长度
 *
 * @author: Liwncy
 * @date: 2020-10-12 15:46
 **/
public class Leet0058 {
    public static void main(String[] args) {
        Leet0058 leet = new Leet0058();
        System.out.println(leet.lengthOfLastWord("a"));
        System.out.println(leet.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord1(String s) {
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && start == 0) {
                start = i + 1;
            }
            if (s.charAt(i) == ' ' && start != 0) {
                return start - i - 1;
            }
        }
        return start;
    }

    /**
     * todo:未完成
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count != 0) {
                    break;
                }
                continue;
            }
            count++;
        }
        return count;
    }

}
