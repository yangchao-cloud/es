package com.qima.test.zoo.mathtic;

/**
 * @author A80390
 */
public class AddBinary {
    public static void main(String[] args) {
        char a = '0';
        System.out.println(a - '0');
        System.out.println(1 + '0');
        System.out.println(addBinary("1111", "1111"));
    }

    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i=0; i<n; i++) {
            carry += i<a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            carry += i<b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            ans.append((char) (carry%2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
