package com.qdm.datastruct.leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 8, 8, 9, 10};
        int targetIdx  = binarySearch(arr, 8);
        System.out.println("targetIdx = " + targetIdx);
    }

    private static int binarySearch(int[] arr, int target) {
        int targetIdx = arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return targetIdx;
    }











}
