package com.liugs.datastructure.data;

import java.util.ArrayList;

public class EncodeUtil {

    public Integer[] decompressRLElist(int[] nums) {
        // 从提示来看 要创建一个 100 * 100 浪费
        ArrayList<Integer> re = new ArrayList<>();
        int length = nums.length / 2;
        int realIndex = 0;
        int first = nums[0];
        int second = nums[1];
        for(int i = 1;i <= length;i++){
            // 0 2 4
            realIndex = 2 * i - 2;
            first = nums[realIndex];
            second = nums[realIndex + 1];
            for(int j = 0;j < first;j++){
                re.add(second);
            }
        }
        return  re.toArray(new Integer[0]);
    }
}
