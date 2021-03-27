package com.qdm.utils;

/**
 * @author qiudm
 * @date 2018/8/27 18:38
 * @desc
 */
public class Utils {
    private static final Integer BLACK_COUNT = 35;

    public static void print(String key, Object o) {
        int count = BLACK_COUNT;
        StringBuffer black = new StringBuffer(" ");
        if (key != null) {
            if (key.length() > BLACK_COUNT) {
                count = 0;
            } else {
                count -= key.length();
            }
        }
        for (int i=0; i<count; i++) {
            black.append(" ");
        }
        System.out.println(key + black + ":   " + o);
    }


}
