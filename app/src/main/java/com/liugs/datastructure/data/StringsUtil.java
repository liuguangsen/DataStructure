package com.liugs.datastructure.data;

public class StringsUtil {

    public static void main(String[] args) {
        String s = reverseWords("  hello world!  ");
        System.out.println("[" + s + "]");
        "".toCharArray();
    }

    public static String reverseWords(String s) {
        // 为啥难度是中等呢
        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            String item = strings[i];
            if (item.equals("")) {
                continue;
            }
            result.append(item.trim()).append(" ");
        }
        return result.toString().trim();
    }
}
