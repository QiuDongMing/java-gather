package com.qdm.datastruct.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 *
 *
 */
public class GenerateParenthesis {


    public static void main(String[] args) {

        GenerateParenthesis gs = new GenerateParenthesis();
//        List<String> gs1 = gs.generateParenthesis(1);
//        System.out.println("gs1 = " + gs1);
        List<String> gs2 = gs.generateParenthesis(2);
        System.out.println("gs2 = " + gs2);
//        List<String> gs3 = gs.generateParenthesis(3);
//        System.out.println("gs3 = " + gs3);


    }


    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> cache = new HashMap<>();
        return getRes(n, cache);
    }


    private List<String> getRes(int n, Map<Integer, List<String>> cache) {
        List<String> res =  new ArrayList();
        if(n==0) {
            res.add("");
            cache.put(0, res);
            return res;
        }

        if(n==1) {
            res.add("()");
            cache.put(1, res);
            return res;
        }

        for(int i=0;i<n;++i) {
            List<String> l = getRes(i, cache);
            List<String> r = getRes(n-1-i, cache);
            for(String ls : l) {
                for(String rs : r) {
                    res.add( "(" + ls + ")" + rs );
                }
            }
        }
        cache.put(n, res);
        return res;
    }















}
