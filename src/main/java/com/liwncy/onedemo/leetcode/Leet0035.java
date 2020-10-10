package com.liwncy.onedemo.leetcode;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 708 👎 0

/**
 * [35]搜索插入位置
 *
 * @author: Liwncy
 * @date: 2020-10-10 08:55
 **/
public class Leet0035 {
    public static void main(String[] args) {
        Leet0035 leet = new Leet0035();
        System.out.println(leet.searchInsert2(new int[]{1, 2, 4, 5, 6}, 3));
    }

    public int searchInsert(int[] nums, int target) {
        int nl = nums.length;
        for (int i = 0; i < nl; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nl;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
