package com.qdm.datastruct.arr;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class MaxSubArray {


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maxSubArray() = " + maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {

        int fPre = 0;
        int maxSubArr = nums[0];
        for (int num : nums) {
            System.out.print("num=" + num + ",fPreBef=" + fPre + ", maxSubArrBef=" + maxSubArr);
            fPre = Math.max(fPre + num, num);
            maxSubArr = Math.max(fPre, maxSubArr);
            System.out.println(", fPre = " +  fPre + "， maxSubArr = " + maxSubArr);
        }


        return maxSubArr;
    }







}
