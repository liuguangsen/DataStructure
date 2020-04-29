package com.liugs.datastructure.data;

import java.util.ArrayList;
import java.util.HashMap;

public class OverUtil {

    public static void main(String [] args){
        String s = "abccccdd";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    public static int longestPalindrome(String s) {
        // 用LIst存取双数的
        ArrayList<Character> itemList = new ArrayList<Character>();
        char[]sChars = s.toCharArray();
        Character sC = null;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < sChars.length;i++){
            Character c = sChars[i];
            if(map.containsKey(c)){
                int size = map.get(c);
                if(size == 2){
                    map.put(c,1);
                } else{
                    itemList.add(c);
                    map.put(c,2);
                }
            } else {
                map.put(c,1);
            }
        }
        int size = itemList.size() * 2;
        return size < sChars.length ? size + 1 : 0;
    }
}
