package com.qdm.datastruct.questions;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/25 13:39
 * @desc 有1元，5元，10元，20元，50元，100元 共花费n元，求每种货币的排列
 */
public class CostResTest {

    @Test
    public void getCostRestTest() {
        System.out.println("getRest1(10) = " + getRest1(10));
    }

    private int getRest1(int n) {
        int costCount = 0;
        int[] moneyType = {1,5,10,20,50,100};
        for (int i = 0; i < n / moneyType[0] + 1; i++) {
            for (int j = 0; j < n / moneyType[1] + 1; j++) {
                for (int k = 0; k < n / moneyType[2]  + 1; k++) {
                    for (int l = 0; l < n / moneyType[3] + 1; l++) {
                        for (int m = 0; m < n / moneyType[4] + 1; m++) {
                            int res = i * moneyType[0] + j * moneyType[1] + k * moneyType[2] +
                                    l * moneyType[3] + m * moneyType[4];
                            int o = n - res;
                            if (o <= n && o % moneyType[5] == 0 && o >= 0) {
                                costCount++;
                                System.out.println(i + "," + j + "," + k + "," + l + "," + m + "," + o);
                            }
                        }
                    }
                }
            }
        }
        return costCount;
    }

}
