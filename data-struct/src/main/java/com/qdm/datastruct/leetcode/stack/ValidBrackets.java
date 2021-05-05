package com.qdm.datastruct.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {

    public static void main(String[] args) {

        System.out.println("isValid = " + isValid("){"));


    }

    public static boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(len % 2 != 0) {
            return false;
        }

        for (int i=0;i<len;i++) {
            Character ch = s.charAt(i);
            if(map.get(ch) != null) {
                stack.push(ch);
            } else {
                Character pk = null;
                try {
                    pk = stack.pop();
                } catch (Exception e) {

                }
                if(pk == null || !map.get(pk).equals(ch)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }











}
