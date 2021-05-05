package com.qdm.datastruct.leetcode;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2}; // [5,5,2,3,4,7]
        nextPermutation(nums);

        Arrays.stream(nums).forEach(s->System.out.print(s));

    }


    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1) {
            return;
        }
        boolean sort = false;

        breakFor:
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[i] < nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    int cos = (i + 1 + nums.length - 1) ;
                    for (int k = i + 1; k <= cos / 2; k++) {
                        int tm = nums[k];
                        nums[k] = nums[cos - k];
                        nums[cos - k] = tm;
                    }


                    sort = true;
                    break breakFor;
                }
            }

        }




        if(sort == false) {
            for(int i=0;i<nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length -1 - i];
                nums[nums.length -1 - i] = tmp;
            }
        }

    }








}
