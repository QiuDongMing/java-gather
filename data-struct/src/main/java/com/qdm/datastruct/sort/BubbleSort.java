package com.qdm.datastruct.sort;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/15 16:37
 * @desc
 */
public class BubbleSort {

    private int[] nums = {2, 1, 4, 7, 8, 6, 5, 3};


    /**
     * 时间复杂度O(n²)
     */
    @Test
    public void bubbleSort() {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int a : nums) {
            System.out.print(a + " ");
        }

    }


}
