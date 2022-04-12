package com.qima.test.zoo.dao;

import java.util.Objects;

/**
 * @author A80390
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args) {
        String[] strs = {"flower","flow","feight"};
        System.out.println("=======================横向扫描 开始===========================");
        String longestCommonPrefix = getLongestCommonPrefix1(strs);
        System.out.println(longestCommonPrefix);
        System.out.println("时间复杂度：O(mn);空间复杂度：O(1)");
        System.out.println("=======================横向扫描 结束===========================");

        System.out.println("=======================纵向扫描 开始===========================");
        String longestCommonPrefix1 = getLongestCommonPrefix2(strs);
        System.out.println(longestCommonPrefix1);
        System.out.println("时间复杂度：O(mn);空间复杂度：O(1)");
        System.out.println("=======================纵向扫描 结束===========================");

        System.out.println("=======================分治思想 开始===========================");
        String longestCommonPrefix2 = getLongestCommonPrefix3(strs);
        System.out.println(longestCommonPrefix2);
        System.out.println("时间复杂度：O(mn);空间复杂度：O(mlogn)");
        System.out.println("=======================分治思想 结束===========================");

        System.out.println("=======================二分查找 开始===========================");
        String longestCommonPrefix3 = getLongestCommonPrefix4(strs);
        System.out.println(longestCommonPrefix3);
        System.out.println("时间复杂度：O(mnlogm);空间复杂度：O(1)");
        System.out.println("=======================二分查找 结束===========================");
    }

    //1 横向扫描
    public static String getLongestCommonPrefix1(String[] strs) {
        //字符串数组为空返回""
        if (Objects.isNull(strs) || 0 == strs.length) {
            return "";
        }
        //选取数组的第一个元素作为标准
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; ++i) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        //选取长度最短的字符串作为前缀的最大长度
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    //纵向扫描
    public static String getLongestCommonPrefix2(String[] strs) {
        if (Objects.isNull(strs)) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i=0; i<length; i++) {
            char c = strs[0].charAt(i);
            for (int j=0; j<count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    //分治
    public static String getLongestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix1(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix1(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix1(strs, start, mid);
            String lcpRight = longestCommonPrefix1(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public static String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    //二分查找
    public static String getLongestCommonPrefix4(String[] strs) {
        if (Objects.isNull(strs)) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0;
        int high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, low);
    }

    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
