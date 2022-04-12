package com.qima.test.zoo.mathtic;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author A80390
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9};
        digits = plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        while (length >= 0 && ++digits[length] == 10) {
            digits[length] = 0;
            length--;
        }
        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else {
            return digits;
        }
    }
}
