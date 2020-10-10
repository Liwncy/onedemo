package com.liwncy.onedemo.leetcode;
//给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
// 注意：整数序列中的每一项将表示为一个字符串。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//
//
// 第一项是数字 1
//
// 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
//
// 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
//
// 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
//
// 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
//
//
//
// 示例 1:
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。
//
// 示例 2:
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
// Related Topics 字符串
// 👍 573 👎 0

/**
 * [38]外观数列
 *
 * @author: Liwncy
 * @date: 2020-10-10 09:27
 **/
public class Leet0038 {
    public static void main(String[] args) {
        Leet0038 leet = new Leet0038();
        System.out.println(leet.countAndSay2(4));
    }

    /**
     * 两层遍历
     *
     * @param n
     * @return
     */
    public String countAndSay1(int n) {
        String say = "1";
        for (int i = 1; i < n; i++) {
            int num = 1;
            StringBuilder fsay = new StringBuilder();
            for (int j = 0; j < say.length(); j++) {
                if (say.length() > 1 && j + 1 < say.length() && say.charAt(j + 1) == say.charAt(j)) {
                    num++;
                } else {
                    fsay.append(num).append(say.charAt(j));
                    num = 1;
                }
            }
            say = fsay.toString();
        }
        return say;
    }

    /**
     * 递归解
     *
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder res = new StringBuilder();
        String say = countAndSay2(n - 1);
        int num = 1;
        for (int j = 0; j < say.length(); j++) {
            if (say.length() > 1 && j + 1 < say.length() && say.charAt(j + 1) == say.charAt(j)) {
                num++;
            } else {
                res.append(num).append(say.charAt(j));
                num = 1;
            }
        }
        return res.toString();
    }

}
