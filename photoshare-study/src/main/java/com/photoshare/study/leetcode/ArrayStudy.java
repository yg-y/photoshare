package com.photoshare.study.leetcode;

import org.junit.Test;

/**
 * @Author:Young
 * @Description LeetCode 数组
 * @Date: 2019/6/6 0006 9:34
 */
public class ArrayStudy {

    /**
     * 从排序数组中删除重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    @Test
    public void removeArrayReturn() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5};

        int i = 0;
        for (int j = 1, h = nums.length; j < h; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        i = i + 1;
        System.err.println(i);
    }

    /**
     * 返回只出现一次的数字
     *
     * 方法四（异或法）：
     *
     * 思路：根据异或运算的特点，相同的数字经过异或运算后结果为0，
     * 除单独出现一次的数字外，其他数字都是出现两次的，那么这些数字经过异或运算后结果一定是0。
     * 而任何数字与0进行异或运算都是该数字本身。所以对数组所有元素进行异或运算，运算结果就是题目的答案。
     */
    @Test
    public void singleNumber() {
        int[] nums = {1, 2, 1, 2, 3, 4, 3, 4, 5, 6, 6};
        int target = 0;
        for (int i = 0, j = nums.length; i < j; i++) {
            target = target ^ nums[i];
        }
        System.err.println(target);
    }


    public static void main(String[] args) {
        System.err.println("aaa");
    }
}
