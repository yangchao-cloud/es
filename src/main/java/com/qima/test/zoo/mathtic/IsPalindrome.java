package com.qima.test.zoo.mathtic;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * @author A80390
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String str = " ";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int length  = s.length();
        for (int i=0; i<length; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        StringBuilder sb_rev = new StringBuilder(sb).reverse();
        return sb.toString().equals(sb_rev.toString());
    }
}
