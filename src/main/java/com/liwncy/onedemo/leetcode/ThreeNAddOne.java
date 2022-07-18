package com.liwncy.onedemo.leetcode;

public class ThreeNAddOne {

  public static void main(String[] args) {

    ThreeNAddOne leet = new ThreeNAddOne();
    // System.out.println(leet.countSteps(15));
    System.out.println(leet.sum(15));
  }

  public int add(int n) {
    int sum = 0;
    int carry = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit;
      carry = sum / 10;
      sum %= 10;
      n /= 10;
    }
    return sum + carry;
  }

  /**
   * 输出从 n 计算到 1 需要的步数
   */
  public int countSteps(int n) {
    int steps = 0;
    while (n > 1) {
      if (n % 2 == 0) {
        n /= 2;
      } else {
        n = n * 3 + 1;
      }
      steps++;
    }
    return steps;
  }

  /**
   * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
   */
  public String sum(int n) {
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit;
      sb.append(sum);
      n /= 10;
    }
    return sb.reverse().toString();
  }
}
