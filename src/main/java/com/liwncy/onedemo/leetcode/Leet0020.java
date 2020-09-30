package com.liwncy.onedemo.leetcode;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1890 👎 0

import java.util.*;

/**
 * [20]有效的括号
 *
 * @author: Liwncy
 * @date: 2020-09-30 11:30
 **/
public class Leet0020 {
    public static void main(String[] args) {
        Leet0020 leet = new Leet0020();
        System.out.println(leet.isValid1("()[{}{[]}]{}"));
    }

    /**
     * 遍历每一个字符,如果它不是下括号,则将其加到Deque里;如果它是下括号,则判断Deque里的第一个是不是它的另一半,是则将其另一半从Deque移除,否则返回false
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * List呈现理解
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 1,判断是否是下括号
            if (pairs.containsKey(ch)) {
                // 下括号看是否与List末尾元素匹配
                int ind = list.size() - 1;
                if (list.isEmpty() || !list.get(ind).equals(pairs.get(ch))) {
                    return false;
                }
                // 匹配上移除List最后元素
                list.remove(ind);
            } else {
                // 上括号添加到List末尾
                list.add(ch);
            }
        }
        return list.isEmpty();
    }
    /**
     * Deque(Double ended queue)是一种线性集合,其允许在集合两端进行数据的插入和删除操作;
     * 1,Deque.push(s) 在头上添加元素s
     * 2,Deque.pop() 移除头部元素
     * 3,Deque.peek() 取出头部元素
     */
}
