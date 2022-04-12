package com.qima.test.zoo.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author A80390
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int result = romanToInt3(s);
        System.out.println(result);
    }

    public static int romanToInt1(String s) {
        if (Objects.isNull(s)) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i=0; i<s.length(); i++) {
            char target = s.charAt(i);
            Integer targetValue = map.get(target);
            boolean judgeFlag = 'I'==target || 'X'==target || 'C'==target;
            if (judgeFlag && i!=s.length()-1) {
                char temp = s.charAt(i+1);
                if ('I' == target) {
                    if ('V'==temp || 'X' == temp) {
                        result = result - targetValue;
                        continue;
                    } else if ('L'==temp || 'C'==temp || 'D'==temp || 'M'==temp) {
                        return 0;
                    }
                }
                if ('X' == target) {
                    if ('L'==temp || 'C' == temp) {
                        result = result - targetValue;
                        continue;
                    } else if ('D'==temp || 'M'==temp){
                        return 0;
                    }
                }
                if ('C'==target) {
                    if ('D'==temp || 'M'==temp) {
                        result = result - targetValue;
                        continue;
                    }
                }
            }

            result = result + targetValue;
        }

        if (result < 1 || result > 3999) {
            return 0;
        }
        return result;
    }

    /**
     * 思路
     * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
     * 例如 \texttt{XXVII}XXVII 可视作 \texttt{X}+\texttt{X}+\texttt{V}+\texttt{I}+\texttt{I}=10+10+5+1+1=27X+X+V+I+I=10+10+5+1+1=27。
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     * 例如 \texttt{XIV}XIV 可视作 \texttt{X}-\texttt{I}+\texttt{V}=10-1+5=14X−I+V=10−1+5=14。
     */
    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt2(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static int romanToInt3(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int value = symbolValues.get(currentChar);
            if (i != n-1) {
                char nextChar = s.charAt(i+1);
                boolean flagOfI = ('I' == currentChar) && ('L'==nextChar || 'C'==nextChar || 'D'==nextChar || 'M'==nextChar);
                boolean flagOfX = ('X' == currentChar) && ('D'==nextChar || 'M'==nextChar);
                if (flagOfI || flagOfX) {
                    return 0;
                }
                if (value < symbolValues.get(nextChar)) {
                    ans -= value;
                    continue;
                }
            }
            ans += value;
        }
        if (ans < 1 || ans > 3999) {
            return 0;
        }
        return ans;
    }
}
