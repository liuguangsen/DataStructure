package com.liugs.datastructure.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SingleNumbersUtil {

    public static void main(String[] args) {

    }

    public static int[] singleNumbers(int[] nums) {
        // 中等难度有点过了
        // 时间复杂度是 O(n) 要遍历每一个元素
        // 空间复杂度是O(1) 不能用迭代
        ArrayList<Integer> items = new ArrayList<>();
        for(int i : nums){
            if(items.contains(i)){
                items.remove(Integer.valueOf(i));
            } else {
                items.add(i);
            }
        }
        int[] result = new int[items.size()];
        for(int i = 0;i < items.size();i++){
            result[i] = items.get(i);
        }
        return result;
    }
}
