package com.qima.test.zoo.mathtic;


/**
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 題目地址：https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode-solution-ds6y/
 * @author A80390
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "abaacababcac";
        String needle = "ababc";
        System.out.println(strStr3(haystack, needle));
    }
    /**
     * 暴力匹配
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i=0; i+needleLength<haystackLength; i++) {
            boolean flag = true;
            for (int j=0; j<needleLength; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }

    public static int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * kmp算法
     * 时间复杂度O(n+m) 空间复杂度O(m)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return m;
        }
        int[] pi = new int[m];
        for (int i=1, j=0; i<m; i++) {
            while(j>0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i=0, j=0; i<n; i++) {
            while (j>0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
