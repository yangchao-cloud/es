package com.qima.test.zoo.dao;

import java.util.Objects;

/**
 * @author A80390
 */
public class LongestCommonPrefix1 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args) {
        String[] strs = {"flower","flow","feight"};
        String result = getLongCommonPrefix1(strs);
        System.out.println(result);
    }

    //二分查找
    public static String getLongCommonPrefix(String[] strs) {
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
            boolean flag = true;
            int mid = (high - low + 1) / 2 + low;
            String str0 = strs[0].substring(0, mid);
            for (int i=1; i<strs.length; i++) {
                String str = strs[i];
                for (int j=0; j<mid; j++) {
                    if (str0.charAt(j) != str.charAt(j)) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                low = mid;
            } else {
                high = mid -1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static String getLongCommonPrefix1(String[] strs) {
        if (Objects.isNull(strs)) {
            return "";
        }

        String commonPrefix = strs[0];
        for (int i=0; i<strs.length; i++) {
            while (!strs[i].startsWith(commonPrefix)) {
                if (commonPrefix.length() == 0) {
                    return "";
                }
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }

        return commonPrefix;
    }
}
