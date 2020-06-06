package com.liugs.datastructure.data;

import java.util.Stack;

public class BalancedUtil {

    public static void main(String [] args){
        String test = "RRLL";
        System.out.println(balancedStringSplit(test));
    }

    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        int balance = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'L') {
                balance--;
            }
            if(chars[i] == 'R') {
                balance++;
            }
            if(balance == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
