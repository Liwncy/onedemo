package com.liwncy.oneexamples.javacexp.sorting;


import java.util.Arrays;

/**
 * 八种排序算法与 Java 代码实现！
 */
public class Sorting {

    public static void main(String[] args) {
        int[] arr = new int[]{23, 43, 12, 25, 34, 45, 56, 87, 65, 48, 57, 85};
        Sorting sorting = new Sorting();
        System.out.println("开始");
        // 1.直接插入排序
//        sorting.insertSort(arr);
        sorting.sheelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("结束");
    }

    /**
     * 1.直接插入排序
     * <p>
     * 说明:
     * 经常碰到这样一类排序问题：把新的数据插入到已经排好的数据列中。
     * 将第一个数和第二个数排序，然后构成一个有序序列
     * 将第三个数插入进去，构成一个新的有序序列。
     * 对第四个数、第五个数……直到最后一个数，重复第二步
     * <p>
     * 代码实现:
     * 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
     * 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
     * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
     * 将当前数放置到空着的位置，即j+1。
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        //数组长度
        int length = arr.length;
        //要插入的数
        int insertNum;
        //插入的次数
        for (int i = 1; i < length; i++) {
            //要插入的数
            insertNum = arr[i];
            //已经排序好的序列元素个数
            int j = i - 1;
            //序列从后到前循环，将大于insertNum的数向后移动一格
            while (j >= 0 && arr[j] > insertNum) {
                //元素移动一格
                arr[j + 1] = arr[j];
                j--;
            }
            //将需要插入的数放在要插入的位置。
            arr[j + 1] = insertNum;
        }
    }

    /**
     * 2.希尔排序
     * <p>
     * 说明:
     * 对于直接插入排序问题，数据量巨大时。
     * 将数的个数设为n，取奇数k=n/2，将下标差值为k的数分为一组，构成有序序列。
     * 再取k=k/2 ，将下标差值为k的数分为一组，构成有序序列。
     * 重复第二步，直到k=1执行简单插入排序。
     * <p>
     * 代码实现：
     * 首先确定分的组数。
     * 然后对组中元素进行插入排序。
     * 然后将length/2，重复1,2步，直到length=0为止。
     */
    public void sheelSort(int[] arr) {
        //数组长度
        int k = arr.length;
        while (k != 0) {
            //分的组数
            k = k / 2;
            for (int i = 0; i < k; i++) {
                //组中的元素，从第二个数开始
                for (int j = i + k; j < arr.length; j += k) {
                    //l为有序序列最后一位的位数
                    int l = j - k;
                    //要插入的元素
                    int temp = arr[j];
                    //从后往前遍历
                    for (; l >= 0 && temp < arr[l]; l -= k) {
                        //向后移动d位
                        arr[l + k] = arr[l];
                    }
                    arr[l + k] = temp;
                }
            }
        }
    }
}
