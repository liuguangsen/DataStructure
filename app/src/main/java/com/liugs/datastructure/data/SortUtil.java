package com.liugs.datastructure.data;

import java.util.HashMap;

public class SortUtil {

    public static void main(String[] args) {
        int[] src = {1, 6, 4, 9, 2, 3, 7, 0, 8, 5, 10, 24, 28};
        // 01234  56789 10 24 28
//        maoPao(src);

        quick(src,0,src.length - 1);
        print(src);
    }

    private static void quick(int[] src, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partition = partition(src, leftIndex, rightIndex);
            quick(src, leftIndex, partition - 1);
            quick(src, partition + 1, rightIndex);
        }
    }

    private static int partition(int[] src, int leftIndex, int rightIndex) {
        int pivot = leftIndex;
        int index = pivot + 1;
        for (int i = index; i <= rightIndex; i++) {
            if (src[i] < src[pivot]) {
                swap(src, i, index);
                index++;
            }
        }
        swap(src, pivot, index - 1);
        return index - 1;
    }

    private static int[] maoPao(int[] src) {
        if (src == null) {
            return src;
        }
        int length = src.length;
        for (int i = 1; i < length; i++) {
            boolean isNotSwap = true;
            for (int j = 0; j < length - i; j++) {
                if (src[j] > src[j + 1]) {
                    swap(src, j, j + 1);
                    isNotSwap = false;
                }
            }
            if (isNotSwap) {
                break;
            }
        }
        return src;
    }

    private static void swap(int[] src, int i, int j) {
        int temp;
        temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    private static void print(int[] src) {
        if (src == null) {
            return;
        }
        for (int i : src) {
            System.out.print(i + " ");
        }
    }

}
