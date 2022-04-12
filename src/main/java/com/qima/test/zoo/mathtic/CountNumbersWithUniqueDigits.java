package com.qima.test.zoo.mathtic;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10的n次方
 * @author A80390
 */
public class CountNumbersWithUniqueDigits {
    /**
     * 排列组合
     * @param n
     * @return
     */
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int countNumbersWithUniqueDigits1(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
