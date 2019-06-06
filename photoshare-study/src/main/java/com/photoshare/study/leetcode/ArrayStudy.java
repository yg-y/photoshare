package com.photoshare.study.leetcode;

import org.junit.jupiter.api.Test;

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


    public static void main(String[] args) {
        System.err.println("aaa");
    }
}
