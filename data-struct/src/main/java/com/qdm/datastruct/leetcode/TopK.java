package com.qdm.datastruct.leetcode;

import java.util.PriorityQueue;

// 1 2 5 6 7 8 3 9 找出第3大的数
public class TopK {

    public static void main(String[] args) {
        int k = 5;
        int[] arr = new int[]{1, 2, 5, 6, 7, 8, 3, 9, 4};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (minHeap.size() < k || arr[i] > minHeap.peek()) {
                minHeap.offer(arr[i]);
            }
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (minHeap.size() > 0) {
            System.out.println("minHeap = " + minHeap.poll());
        }

    }





}
