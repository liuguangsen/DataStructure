package com.liugs.datastructure.data;

import java.util.HashMap;

public class ContainKeyUtil {

    public int numJewelsInStones(String J, String S) {
        // 构建一个查找表
        HashMap<Character,Integer> b = new HashMap<>();
        char[] src = S.toCharArray();
        for(char c : src){
            int size;
            if(b.containsKey(c)){
                size = b.get(c);
                ++size;
            } else {
                size = 1;
            }
            b.put(c,size);
        }
        char[] jSrc = J.toCharArray();
        int sum = 0;
        for(char jC : jSrc){
            if(b.containsKey(jC)){
                sum += b.get(jC);
            }
        }
        return sum;
    }
}
