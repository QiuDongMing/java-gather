package com.qdm.datastruct.sort;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/15 16:37
 * @desc
 */
public class InsertSort {

    private int[] nums = {2, 1, 4, 7, 8, 6, 5, 3};


    /**
     * 时间复杂度O(n²)
     */
    @Test
    public void insertSort() {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];//保存第i位的值
                int k = i - 1;
                for (int j = k; j >= 0 && temp < nums[j]; j--) { //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                    nums[j + 1] = nums[j];
                    k--;
                }
                nums[k + 1] = temp;//插入第i位的值
            }
        }
        for (int a : nums) {
            System.out.print(a + " ");
        }

    }


}
