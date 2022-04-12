package com.qima.test.zoo.mathtic;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author A80390
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,2,2,3,3};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
