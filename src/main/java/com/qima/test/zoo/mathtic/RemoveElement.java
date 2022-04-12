package com.qima.test.zoo.mathtic;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author A80390
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    /**
     * 时间复杂度：O(n)，其中 n为序列的长度。我们只需要遍历该序列至多两次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        int fast = 0;
        int low = 0;
        for (; fast<n; fast++) {
            if (nums[fast] != val) {
                nums[low++] = nums[fast];
            }
        }
        return low;
    }

    /**
     * 如果左指针 left 指向的元素等于 val，此时将右指针 right 指向的元素复制到左指针
     * left 的位置，然后右指针 right 左移一位。如果赋值过来的元素恰好也等于 val，可
     * 以继续把右指针 right 指向的元素的值赋值过来（左指针 left 指向的等于 val 的元
     * 素的位置继续被覆盖），直到左指针指向的元素的值不等于 val 为止。
     * 当左指针 left 和右指针 right 重合的时候，左右指针遍历完数组中所有的元素。
     * 这样的方法两个指针在最坏的情况下合起来只遍历了数组一次。与方法一不同的是，
     * 方法二避免了需要保留的元素的重复赋值操作。
     * 双指针优化
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left<right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
