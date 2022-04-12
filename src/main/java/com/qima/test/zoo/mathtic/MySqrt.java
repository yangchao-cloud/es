package com.qima.test.zoo.mathtic;

/**
 * @author A80390
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt1(5));
        System.out.println(mySqrt2(5));
    }

    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5*Math.log(x));
        return (long)(ans + 1) * (ans+1) <= x ? ans+1 : ans;
    }

    /**
     * 由于 x 平方根的整数部分 ans 是满足 k*K≤x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。
     * 二分查找的下界为 0，上界可以粗略地设定为 x。在二分查找的每一步中，
     * 我们只需要比较中间元素mid 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围。
     * 由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案
     * ans 后，也就不需要再去尝试 ans+1 了。
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while(l<=r) {
            int mid = l + (r -l)/2;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
