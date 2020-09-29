package com.liwncy.onedemo.leetcode;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
// 👍 2218 👎 0


/**
 * [7]整数反转
 *
 * @author: Liwncy
 * @date: 2020-09-29 13:43
 **/
public class Leet0007 {
    public static void main(String[] args) {
        Leet0007 leet = new Leet0007();
        System.out.println(leet.reverse1(534236469));
        System.out.println(leet.reverse2(534236469));
    }

    /**
     * 转成字符数组,处理完转回来--字符串转int有限制
     *
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int fx = 0;
        String[] str = (Math.abs(x) + "").split("");
        String s = x >= 0 ? "" : "-";
        for (int i = str.length - 1; i >= 0; i--) {
            s += str[i];
        }
        try {
            fx = Integer.parseInt(s, 10);
        } catch (Exception e) {
            return 0;
        }
        return fx;
    }

    /**
     * 循环/10取余*10+余数
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int fx = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (fx > Integer.MAX_VALUE / 10 || (fx == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (fx < Integer.MIN_VALUE / 10 || (fx == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            fx = fx * 10 + pop;
        }
        return fx;
    }


    /**
     * 1,Integer.parseInt(s)字符串转int类型方法有限制["-2147483648","2147483647"];
     * 2,Math
     * Math.sqrt(); //计算平方根
     * Math.cbrt(); //计算立方根
     * Math.pow(a, b); //计算a的b次方
     * Math.max( , ); //计算最大值
     * Math.min( , ); //计算最小值
     */
}
