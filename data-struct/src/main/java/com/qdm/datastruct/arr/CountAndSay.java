package com.qdm.datastruct.arr;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println("s = " + s);

    }


    /**
     *   countAndSay(2) =
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        if (map.get(n) != null) {
            return map.get(n);
        }

        for (int k = 2; k <= n; k++) {
            if (map.get(k) != null) {
                continue;
            }
            String s = map.get(k - 1);
            char c = s.charAt(0);
            int ct = 1;
            StringBuffer sb = new StringBuffer();
            for(int i = 1; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == c) {
                    ct++;
                } else {
                    sb.append(ct).append(c);
                    c = cur;
                    ct = 1;
                }
            }
            sb.append(ct).append(c);
            map.put(k, sb.toString());
        }

        return map.get(n);
    }






}
