package com.liugs.datastructure.data;

import java.util.Arrays;

public class UpUtil {
    public static void main(String[] args) {
        int[] src = {1, 4, 3, 6, 7, 9, 4, 10, 5, 6};
        lengthOfLIS(src);
    }

    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
//        int[] src = {1, 4, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    System.out.println(Arrays.toString(dp));
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            System.out.println(maxans + 1);
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    private static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 从结果来看，最后一个肯定是在数组之内，那就遍历
        // 用新的等长数组，对应下标存符合规律的长度值
        // 外层循环length - 1,内层要遍历 i - 1 所以空间复杂度 O(n2)
        int length = nums.length;
        int maxLength = 1;
        for (int i = length - 1; i > 0; i--) {
            // 内部查找符合规律的元素
            int pivot = nums[i];
            int itemLength = 1;
            for (int j = i - 1; j >= 0; j--) {
                // 注意想等也算
                if (nums[j] < pivot) {
                    pivot = nums[j];
                    itemLength++;
                }
            }
            System.out.println(itemLength);
            // 查找完毕，把长度值存入对应下标的位置
            if (itemLength > maxLength) {
                maxLength = itemLength;
            }
        }
        return maxLength;
    }
}
