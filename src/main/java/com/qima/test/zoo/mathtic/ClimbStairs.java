package com.qima.test.zoo.mathtic;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author A80390
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }

    public static int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i=0; i<n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }

    public static int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}
