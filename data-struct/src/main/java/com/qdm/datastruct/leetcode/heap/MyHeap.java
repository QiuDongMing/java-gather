package com.qdm.datastruct.leetcode.heap;


import java.util.Arrays;

/**
 *
 * leftNo = 2 * parentNo + 1
 * rightNo = 2 * parentNo + 2
 * parentNo = (currentNo - 1) / 2
 *
 */
public class MyHeap {

    private int capacity;

    private int[] data;


    public MyHeap() {

    }

    public MyHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }


//    public void peek(int ele) {
//        int k =
//    }

    public void buildMaxHeap(int[] array) {
        if (array == null) {
            return;
        }
        capacity = array.length;
        if (array.length == 1) {
            data = array;
            return;
        }
        // 堆的公式就是 int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int cursor = capacity / 2;
        for (int i = cursor; i >= 0; i--) {
            // 这样for循环下，就可以第一次排序完成
            maxHeap(array, array.length, i);
        }
    }

    public void buildMinHeap(int[] array) {
        if (array == null) {
            return;
        }
        capacity = array.length;
        if (array.length == 1) {
            data = array;
            return;
        }
        // 堆的公式就是 int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int cursor = capacity / 2;
        for (int i = cursor; i >= 0; i--) {
            // 这样for循环下，就可以第一次排序完成
            minHeap(array, array.length, i);
        }
    }


    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxIndex = index;

        if (left < heapSize && array[left] > array[maxIndex]) {
            maxIndex = left;
        }

        if (right < heapSize && array[right] > array[maxIndex]) {
            maxIndex = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxIndex != index) {
            swap(array, maxIndex, index);
            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            maxHeap(array, heapSize, maxIndex);
        }
    }


    private void minHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxIndex = index;

        if (left < heapSize && array[left] < array[maxIndex]) {
            maxIndex = left;
        }

        if (right < heapSize && array[right] < array[maxIndex]) {
            maxIndex = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxIndex != index) {
            swap(array, maxIndex, index);
            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            minHeap(array, heapSize, maxIndex);
        }
    }




    // 数组元素交换
    private  void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public void heapSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

//        buildMaxHeap(array);

        buildMinHeap(array);

        System.out.println("after Maxheap array = " + Arrays.toString(array));

        for (int i = array.length - 1; i >= 1; i--) {
            // 这个是什么意思呢？，经过上面的一些列操作，目前array[0]是当前数组里最大的元素，需要和末尾的元素交换
            // 然后，拿出最大的元素
            swap(array, 0, i);

            // 交换完后，下次遍历的时候，就应该跳过最后一个元素，也就是最大的那个值，然后开始重新构建最大堆
            // 堆的大小就减去1，然后从0的位置开始最大堆
            minHeap(array, i, 0);
//            minHeap(array, i, 0);
            System.out.println("array = " + Arrays.toString(array));
        }

    }



    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] array = {5, 3, 7, 6, 1, 9, 2, 4};
        System.out.println("array = " + Arrays.toString(array));
//        myHeap.buildMaxHeap(array);
        myHeap.heapSort(array);
        System.out.println("array = " + Arrays.toString(array));
    }





















}
