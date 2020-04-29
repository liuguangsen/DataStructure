package com.liugs.datastructure.data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class RoundUtil {

    public static void main(String [] args){
        int i = lastRemaining(5, 3);
        System.out.println(i);
    }

    private static int lastRemaining(int n, int m) {
        // 依据题意 应该是圆形链表 最好做 实在不行就一步步走吧 取余法
        LinkedList<Integer> src = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            src.add(i);
        }
        int index = 0;
        int j = n;
        boolean isOver =false;
        Iterator<Integer> iterator = src.iterator();
        while (!isOver){
            System.out.println(src);
            // 取余法，移除那个位置
            int current = index;
            index = (current + m - 1) % j;
            src.remove(index);
            j--;
            if (src.size() == 1){
                isOver = true;
            };
        }
        return src.get(0);
    }

    public static int lastRemaining1(int n, int m) {
        // 依据题意 应该是圆形链表 最好做 实在不行就一步步走吧
        boolean over = false;
        int length = 0;

        int[]src = new int[n];
        Arrays.fill(src,1);
        // 外层元素遍历
        int startIndex = 0;
        // 内层步数计数
        int inNum = 0;
        while(!over) {
            int currentIndex = startIndex;
            System.out.print(currentIndex);
            if(src[currentIndex] != -1){
                ++inNum;
                if(inNum == m){
                    src[currentIndex] = -1;
                    ++length;
                    inNum = 0;
                }

            }

            startIndex = ++currentIndex %(n);
            if(length >= n - 1){
                over = true;
            }
        }
        int num = -1;
        // 最后遍历一遍数组 不是-1的 下标
        for(int i = 0; i < n;i++){
            if(src[i] != -1){
                num = i;
            }
        }
        return num;
    }
}
