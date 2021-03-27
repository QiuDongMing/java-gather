package com.qdm.datastruct.sort;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/15 16:37
 * @desc
 */
public class ChoiceSort {

    private int[] nums = {2, 1, 4, 7, 8, 6, 5, 3};


    /**
     * 时间复杂度O(n²)
     */
    @Test
    public void choiceSort() {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] = nums[i];
            nums[i] = min;
        }

        for (int a : nums) {
            System.out.print(a + " ");
        }

    }


}
