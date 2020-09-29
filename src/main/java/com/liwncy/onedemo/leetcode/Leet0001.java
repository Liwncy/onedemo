package com.liwncy.onedemo.leetcode;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 9239 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1]两数之和
 *
 * @author: Liwncy
 * @date: 2020-09-29 08:49
 **/
public class Leet0001 {
    public static void main(String[] args) {
        Leet0001 leet = new Leet0001();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 17;
        int[] result1 = leet.twoSum1(nums, target);
        int[] result2 = leet.twoSum2(nums, target);
        int[] result3 = leet.twoSum3(nums, target);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 将数组放到map利用containsKey()匹配值,减少复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && i != map.get(complement)) {
                arr[0] = i;
                arr[1] = map.get(complement);
                break;
            }
        }
        return arr;
    }

    /**
     * 减少一次循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                arr[0] = i;
                arr[1] = map.get(complement);
                break;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
    /**
     * 1,Map.containsKey()方法--判断Map集合对象中是否包含指定的键名;
     */
}
