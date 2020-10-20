package com.liwncy.onedemo.leetcode;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 497 👎 0

/**
 * [67]二进制求和
 *
 * @author: Liwncy
 * @date: 2020-10-13 10:04
 **/
public class Leet0067 {
    public static void main(String[] args) {
        Leet0067 leet = new Leet0067();
//        System.out.println('0' + 0);
//        System.out.println('1' + 0);
//        System.out.println('0' + '0');
//        System.out.println('0' + '1');
//        System.out.println('1' + '0');
//        System.out.println('1' + '1');
        System.out.println(leet.addBinary1("1010", "1011"));
        System.out.println(leet.addBinary1("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int nl = Math.max(al, bl);
        int carry = 0;
        for (int i = 1; i <= nl; i++) {
            int an = al - i >= 0 ? a.charAt(al - i) - '0' : 0;
            int bn = bl - i >= 0 ? b.charAt(bl - i) - '0' : 0;
            int sum = an + bn + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        if(carry != 0){
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    /**
     * 转换成十进制,求和返回(不行,数字过大后失败)
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        String binary = Integer.toBinaryString(sum);
        return binary;
    }
    /**
     * 1,Integer.parseInt("1010", 2); 字符串转数字,后一个参数是进制;
     * 2,Integer.toBinaryString(21); 十进制转二进制字符串;
     */
}
