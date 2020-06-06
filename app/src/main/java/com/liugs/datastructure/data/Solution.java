package com.liugs.datastructure.data;

public class Solution {

    public static void main(String[] args) {
        String t1 = "10[a]10[bc]ab";
        String t2 = "3[a2[c]]";
        String t3 = "2[abc]3[cd]ef";

        String s = decodeString(t1);
        System.out.println(s);
    }

    static String src;
    static int ptr;

    public static String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public static String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        System.out.println(cur + " " + ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public static int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
