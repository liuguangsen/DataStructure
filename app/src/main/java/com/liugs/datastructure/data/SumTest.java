package com.liugs.datastructure.data;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 找出前面两个符合 两个数字和为target的下标
 */
public class SumTest {

    public static void main(String[] args){
        int[] ints = {7, 2, 11, 15};
        int[] ints1 = twoSum(ints, 9);
        System.out.println(Arrays.toString(ints1));
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> handleMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int num = target - nums[i];
            if(handleMap.containsKey(num)){
                result[0] = handleMap.get(num);
                result[1] = i;
                break;
            }
            handleMap.put(nums[i],i);
        }
        return result;
    }
}
