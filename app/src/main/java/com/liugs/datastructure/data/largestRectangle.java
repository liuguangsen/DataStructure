package com.liugs.datastructure.data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class largestRectangle {

    public static void main(String[] args) {
        int[] src ={2,3};
        int i = largestRectangleArea(src);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return heights[0];
        }

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                    stack.removeLast();
                }

                int width ;
                if (stack.isEmpty()){
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                area = Math.max(width * height,area);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                stack.removeLast();
            }

            int width ;
            if (stack.isEmpty()){
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            area = Math.max(width * height,area);
        }

        return area;
    }

    public static int largestRectangleArea2(int[] heights) {
        if(heights == null){
            return 0;
        }
        int length = heights.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return heights[0];
        }
        // 广度搜索 感觉会超时
        // 从结果来看是left 和 right 的面积

        // 以高度为基准，找最大的扩散值 存储没有找到的最大值
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;
        for (int index = 1; index < length; index++) {
            int cH = heights[index];
            System.out.println(index + " " + stack.peek());
            while (!stack.empty() && cH < heights[stack.peek()]){
                int popIndex = stack.pop();
                int height = heights[popIndex];
                int width = index - popIndex;
                area = Math.max(width * height,area);
            }
            stack.push(index);
        }
        // 再把剩余的高度
        while (!stack.empty()){
            int firstPopIndex = stack.pop();
            int height = heights[firstPopIndex];
            int width  = 1;
            if(stack.empty()){
                area = Math.max(height,area);
            } else if(height != heights[stack.peek()]){
                //找出不想等的
                width = firstPopIndex - stack.peek();
                area = Math.max(width * height,area);
            } else {
                // 找出所有的相等的
                int popIndex = firstPopIndex;
                while(!stack.empty() && (heights[popIndex] == heights[stack.peek()])) {
                    popIndex = stack.pop();
                }
                if(stack.empty()) {
                    // 剩余的全是想等的
                    width = firstPopIndex - popIndex + 1;
                } else {
                    width = firstPopIndex - popIndex;
                }
                area = Math.max(width * height,area);
            }
        }
        return area;
    }

    public static int largestRectangleArea1(int[] heights) {
        // 广度搜索 感觉会超时
        // 从结果来看是left 和 right 的面积
        int left = 0;
        int right = 0;
        int current = 0;
        int result = 0;
        for (; left < heights.length; left++) {
            int minHeight = heights[left];
            for (right = left; right < heights.length; right++) {
                // 宽度是有了
                // 找高度最小值
                minHeight = Math.min(minHeight, heights[right]);
                current = (right + 1 - left) * minHeight;
                System.out.println(left + " " + right + " " + current + " " + minHeight);
                result = Math.max(current, result);
            }
        }
        return result;
    }
}
