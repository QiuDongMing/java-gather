package com.qdm.datastruct.lc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auth qiudongming
 * @date 2021/3/27 18:40
 */
public class QuestionSolution {


    public static void main(String[] args) {
        int i = myAtoi("");
        System.out.printf("i="+i);
    }



    public static int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        char beg = str.charAt(0);
        if (beg != '+' && beg != '-' && !Character.isDigit(beg)) {
            return 0;
        }
        int sign = beg == '-' ? -1 : 1;
        int i = (beg == '+' || beg == '-')  ? 1 : 0;
        char cur = ' ';
        int res = 0;
        while (i < len && Character.isDigit (cur = str.charAt(i))) {
            if (res + cur - '0' > Integer.MAX_VALUE / 10) {
                if (sign == -1) {
                    res = -Integer.MIN_VALUE;
                } else {
                    res = Integer.MAX_VALUE;
                }
                break;
            }
            res = res * 10 + cur - '0';
            ++i;
        }
        res = res * sign;
        return res;
    }





}
