package com.liugs.datastructure.data;

import java.util.Arrays;

public class MindleUtil {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};

        findMedianSortedArrays(a, b);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 如果是偶数是 需要中间两个点 和 的一半
        // 如果是奇数是 中间的数字
        // 总体来说是两个点 到中间的位置
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int nums1Left = 0;
        int nums2Left = 0;
        // 两个数组合并为1
        int sumLength = nums1Length + nums2Length;
        int[] sum = new int[sumLength];
        for (int i = 0; i < sumLength; i++) {
            if (nums1Left == nums1Length) {
                sum[i] = nums2[nums2Left];
                nums2Left++;
                continue;
            }
            if (nums2Left == nums2Length) {
                sum[i] = nums1[nums1Left];
                nums1Left++;
                continue;
            }
            int n1 = nums1[nums1Left];
            int n2 = nums2[nums2Left];
            if (n1 < n2) {
                sum[i] = nums1[nums1Left];
                nums1Left++;
            } else {
                sum[i] = nums2[nums2Left];
                nums2Left++;
            }
        }
        System.out.println(Arrays.toString(sum));
        double result;
        int index = sumLength / 2;
        // 获取结果
        if (sumLength % 2 == 0) {
            result = (sum[index] + sum[index - 1]) / 2.0;
        } else {
            result = sum[index];
        }
        System.out.println(result);
        return result;
    }
}
