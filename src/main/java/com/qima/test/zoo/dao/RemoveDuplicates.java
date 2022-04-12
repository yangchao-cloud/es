package com.qima.test.zoo.dao;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author A80390
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        System.out.println(removeDuplicates2(nums));
    }

    /**
     * 时间复杂度：O(n)，其中 n 是数组的长度。快指针和慢指针最多各移动 n 次。
     * 空间复杂度：O(1)。只需要使用常数的额外空间。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        int fast = 1;
        int low = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast-1]) {
                nums[low] = nums[fast];
                ++low;
            }
            ++fast;
        }
        return low;
    }

    public static int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int j = 1;
        for (int i=1; i<n; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
