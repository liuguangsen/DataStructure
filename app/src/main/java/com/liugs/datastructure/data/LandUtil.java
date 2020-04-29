package com.liugs.datastructure.data;

import android.text.TextUtils;

public class LandUtil {

    public static void main(String[] args) {
        String test = "bb";
        String s = compressString1(test);
        System.out.println(s);
    }

    public static String compressString1(String S) {
        if (S == null || S.length() == 0){
            return S;
        }
        char[] src = S.toCharArray();

        StringBuilder sb = new StringBuilder();
        char pivot = src[0];
        int count = 1;

        for (int i = 1; i < src.length; i++) {
            if (pivot == src[i]){
                ++count;
            } else {
                sb.append(pivot).append(count);
                if (sb.length() >= src.length){
                    return S;
                }
                pivot = src[i];
                count = 1;
            }
        }
        sb.append(pivot).append(count);

        return sb.length() >= src.length ? S:sb.toString();
    }

    public static String compressString(String S) {
        // 要查找元素的数目，时间复杂度 0(N)，空间复杂度0(1)
        char[] src = S.toCharArray();
        int length = src.length;

        char[] result = new char[length];
        int resultIndex = -1;

        char pivot = 0;
        int pivotSize = 0;
        boolean isOver = false;
        for (int i = 0; i < length; i++) {
            // 先把参照字符处理了
            if (src[i] != pivot) {
                // 先把之前的item 处理
                ++resultIndex;
                if (resultIndex >= length) {
                    isOver = true;
                    break;
                }
                pivot = src[i];
                result[resultIndex] = pivot;
                System.out.println(resultIndex + " " + new String(result));
                // 再处理number
                ++resultIndex;
                if (resultIndex >= length) {
                    isOver = true;
                    break;
                }
                pivotSize = 1;
            } else {
                pivotSize++;
            }
            // 最后处理item对应的length
            result[resultIndex] = String.valueOf(pivotSize).toCharArray()[0];
        }
        if (isOver) {
            return S;
        } else {
            char[] dest = new char[resultIndex + 1];
            System.arraycopy(result, 0, dest, 0, resultIndex + 1);
            return new String(dest);
        }
    }
}
