package com.qdm.datastruct.sort;

public class QuickSortMy {


    public static void main(String[] args) {


    }


    private void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = splitArr(arr);

        quickSort(arr, start, mid);
        quickSort(arr, mid + 1, end);
    }


    // 5 9 2 4 8 6 7
    // 2 5 9 4 8 6 7



    private int splitArr(int[] arr) {
        int mid = 0;
        int val = arr[mid];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= val) {
                mid++;
                int tmp = arr[i];


            }
        }


        return mid;
    }












}
