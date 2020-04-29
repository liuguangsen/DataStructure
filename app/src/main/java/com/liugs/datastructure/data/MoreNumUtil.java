package com.liugs.datastructure.data;

import java.util.HashMap;

public class MoreNumUtil {

    public int majorityElement(int[] nums) {
        // 时间复杂度 O(N),每个数字都要遍历一遍
        HashMap<Integer,Integer> items = new HashMap<>();
        int length = nums.length;
        int num = 0;
        for(int i = 0;i < length;i++){
            int itemLength = items.get(i);
            int newItemLength = itemLength + 1;
            items.put(i,newItemLength);
            if(newItemLength > length / 2){
                num = i;
                break;
            }
        }
        return num;
    }
}
