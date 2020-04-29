package com.liugs.datastructure.data;

import java.util.HashMap;

public class WordUtil {

    public static void main(String [] args){
        String []s ={"cat","bt","hat","tree"};
        String pivot = "atach";
        int i = countCharacters(s, pivot);
        System.out.println(i);
    }

    public static int countCharacters(String[] words, String chars) {
        if (chars == null || words == null){
            return 0;
        }
        // 先处理下chars
        char [] cs = chars.toCharArray();
        HashMap<String,Integer> pivot = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            String c = String.valueOf(cs[i]);
            if (pivot.containsKey(c)){
                int size = pivot.get(c);
                pivot.put(c,++size);
            } else {
                pivot.put(c,1);
            }
        }
        int sum = 0;
        // 顺序遍历所有的元素
        for(int i = 0; i < words.length;i++){
            String item = words[i];
            // 进行检查
            if (checkWord(item,new HashMap<String, Integer>(pivot))){
                sum += item.length();
            }
        }
        return sum;
    }

    private static boolean checkWord(String item,HashMap<String,Integer> pivot){
        char[] cs = item.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            String c = String.valueOf(cs[i]);
            if (!pivot.containsKey(c)){
                return false;
            }
            int size = pivot.get(c);
            if (size == 0){
                return false;
            }
            pivot.put(c,--size);
        }
        return true;
    }
}
