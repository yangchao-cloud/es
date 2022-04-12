package com.qima.test.zoo.algrithm;

/**
 * @author A80390
 */
public class LastWordLength {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon    ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord1(s));
        System.out.println(lengthOfLastWord2(s));
    }

    public static int lengthOfLastWord(String s) {
        char[] charArr = s.toCharArray();
        int length = 0;
        int tempLength = 0;
        for (char c : charArr) {
            if (c == 32) {
                tempLength = 0;
                continue;
            }
            tempLength ++;
            if (tempLength > 0) {
                length = tempLength;
            }
        }

        return length;
    }

    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public static int lengthOfLastWord2(String s) {
        int index = s.length() - 1;
        while (index>=0 && s.charAt(index) == ' ') {
            index--;
        }
        int lastWordLength = 0;
        while (index>=0 && s.charAt(index) != ' ') {
            lastWordLength++;
            index--;
        }

        return lastWordLength;
    }

    public static int lengthOfLastWord3(String s) {
        int n = s.length();
        int j = n - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        int i = j;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return j - i;
    }
}
