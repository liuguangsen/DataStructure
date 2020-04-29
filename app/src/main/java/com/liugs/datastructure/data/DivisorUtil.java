package com.liugs.datastructure.data;

public class DivisorUtil {

    public static void main(String[]args){
        String str1 = "ABCABC";
        String str2 = "ABC";
        String s = gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = (int)str1.length(), len2 = (int)str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i){ // 从长度大的开始枚举
            if (len1 % i == 0 && len2 % i == 0){
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) return X;
            }
        }
        return "";
    }

    public static boolean check(String t,String s){
        int lenx = (int)s.length() / (int)t.length();
        String ans = "";
        for (int i = 1; i <= lenx; ++i){
            ans = ans + t;
        }
        return ans == s;
    }
}
