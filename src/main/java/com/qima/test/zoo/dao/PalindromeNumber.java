package com.qima.test.zoo.dao;

/**
 * @author A80390
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        boolean result = isPalindrome1(10);
        System.out.println(result);
    }
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     */
    public static boolean isPalindrome(int x) {
        int temp = x;
        if (x<0) {
            return false;
        }
        int palindromeNumber = 0;
        while (x != 0) {
            if (palindromeNumber > Integer.MAX_VALUE /10) {
                return false;
            }

            int digit = x % 10;
            x = x / 10;
            palindromeNumber = palindromeNumber * 10 + digit;
        }

        return palindromeNumber == temp;
    }

    public static boolean isPalindrome1(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        boolean initJudge = x<0 || (x%10==0 && x!=0);
        if (initJudge) {
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            int digit = x % 10;
            reverseNum = reverseNum * 10 + digit;
            x = x / 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == reverseNum || x == reverseNum / 10;
    }
}
