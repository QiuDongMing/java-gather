package com.qdm.datastruct.arr;

import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int missMinNum = firstMissingPositive2(nums);
        System.out.println("missMinNum = " + missMinNum);
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet();
        for(int i=0; i<nums.length;i++) {
            if(nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        Integer min = 0;
        boolean isBreak = false;
        for(Integer c : set) {
            ++min;
            if(min < c) {
                isBreak = true;
                break;
            }
        }
        return isBreak ? min : min + 1;
    }

    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }







}
