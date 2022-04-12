package com.qima.test.zoo.mathtic;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m
 * 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @author A80390
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,5,0,0};
        int[] nums2 = new int[] {3,4};
        merge3(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int p = 0;
        System.out.println(p++);
        System.out.println(p);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0; i<n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int cur;
        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i=0; i!= m+n; i++) {
            nums1[i] = sorted[i];
        }
    }
}
