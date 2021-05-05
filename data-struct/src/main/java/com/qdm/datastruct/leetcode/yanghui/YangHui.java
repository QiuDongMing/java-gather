package com.qdm.datastruct.leetcode.yanghui;

import java.util.ArrayList;
import java.util.List;

/**
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class YangHui {

    public static void main(String[] args) {
//
//        for(int i=1;i<6;i++) {
//            System.out.println(getRows(i));
//        }

        List<List<Integer>> res = new ArrayList();
        for(int j = 0; j < 8; j++) {
            List<Integer> list = new ArrayList();
            for(int i = 0; i < j; i++) {
                if(i == 0 || i == j - 1) {
                    list.add(1);
                } else {
                    list.add(res.get(j-1).get(i-1) + res.get(j-1).get(i));
                }
            }
            res.add(list);
        }

        System.out.println(res);




    }

    private static List<Integer> getRows(int rows) {
        List<Integer> rowsRes = new ArrayList<>();
        rowsRes.add(1);
        if(rows > 1) {
            List<Integer> befRows = getRows(rows - 1);
            for(int i=1;i<rows - 1;i++) {
                rowsRes.add(befRows.get(i-1) + befRows.get(i));
            }
            rowsRes.add(1);
        }
        return rowsRes;
    }




}
