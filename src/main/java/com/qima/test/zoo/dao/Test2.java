package com.qima.test.zoo.dao;

public class Test2 {
    public static void main(String[] args) {
        int rev = reverse(461616154);
        System.out.println(rev);
    }
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }

        return rev;
    }
}
