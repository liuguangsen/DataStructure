package com.liugs.datastructure.data;

import java.util.HashMap;

public class BeizhuUtil {

    public static void main(String[] args) {
        boolean b = canMeasureWater(2, 6, 5);
        System.out.println(b);
        int gcd = gcd(3, 5);
        System.out.println(gcd);
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || x + y == z;
        return z % gcd(x, y) == 0;
    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public boolean hasGroupsSizeX(int[] deck) {
        // 第一次遍历没法避免，每个元素都要来一遍 ,第二次和第三次考虑优化下 时间复杂度
        if(deck == null || deck.length == 1){
            return false;
        }

        // 每个元素都要遍历一遍,需要知道元素的length
        HashMap<Integer,Integer> items = new HashMap<Integer,Integer>();
        for(int i = 0;i < deck.length;i++){
            int iItem = deck[i];
            int iSize;
            if(items.containsKey(iItem)){
                iSize = items.get(iItem);
                ++iSize;
            } else {
                iSize = 1;
            }
            items.put(iItem,iSize);
        }
        // 再遍历最小的length
        int small = items.get(deck[0]);
        for(int i :items.values()){
            if(i < small){
                small = i;
            }
        }
        if(small < 2){
            return false;
        }
        // 还要再遍历一次,看结果，所有的size总是最小的倍数
        boolean isOk = true;
        for(int i :items.values()){
            if(getMaxCommonNum(small,i) < 2){
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    private int getMaxCommonNum(int i ,int j){
        if(j == 0){
            return i;
        } else {
            return getMaxCommonNum(j , i % j);
        }
    }

}
