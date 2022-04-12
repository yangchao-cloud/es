package com.qima.test.zoo.dao;

import java.util.*;

/**
 * @author A80390
 */
public class ValidParentheses {
    /**
     * 40 41 91 93 123 125
     * @param args
     */
    public static void main(String[] args) {
        isValid1("(([]){})");
        isValid2("(([]){})");
    }
    public static boolean isValid1(String s) {
        if (Objects.isNull(s) || s.length() % 2 ==1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
                continue ;
            } else if (c == '[') {
                stack.push(']');
                continue ;
            } else if (c == '{') {
                stack.push('}');
                continue ;
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public static boolean isValid2(String s) {
        if (Objects.isNull(s) || s.length() % 2 ==1) {
            return false;
        }
        LinkedList<Character> linkedList = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) {
                linkedList.addLast(c);
            } else if(!map.get(linkedList.removeLast()).equals(c)) {
                return false;
            }
        }
        return linkedList.size() == 1;
    }
}
