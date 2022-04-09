package com.qdm.datastruct.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiudm
 * @date 2019/1/15 16:37
 * @desc
 */
public class QuickSort {

    private int[] nums = {2, 1, 4, 7, 8, 6, 5, 3};


    /**
     * 时间复杂度O(nlogn)
     */
    @Test
    public void quickSort() {
        quickSort(nums,0, nums.length-1);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }


    private void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int key = nums[left];/*用字表的第一个记录作为枢轴*/
        int first = left;
        int last = right;
        while (first < last) {

            while (first < last && nums[last] >= key) {
                last--;
            }
            nums[first] = nums[last];/*将比第一个小的移到低端*/

            while (first < last && nums[first] <= key) {
                first++;
            }
            nums[last] = nums[first];/*将比第一个大的移到高端*/
        }

        nums[first] = key;/*枢轴记录到位*/
        quickSort(nums, left, first-1);
        quickSort(nums, first+1, right);
    }






    @Test
    public void myQuickSort() {
        int[] arr = {3, 1, 2, 5 ,6, 9, 7, 4, 8};
        myQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public void myQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int key = arr[left];
        int first = left;
        int last = right;

        while (first < last) {
            while (first < last && arr[last] >= key) {
                last--;
            }
            arr[first] = arr[last];

            while (first < last && arr[first] <= key) {
                first++;
            }
            arr[last] = arr[first];
        }
        arr[first] = key;
        myQuickSort(arr, left, first-1);
        myQuickSort(arr, first + 1, right);
    }































}
