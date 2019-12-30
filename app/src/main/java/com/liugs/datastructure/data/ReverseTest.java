package com.liugs.datastructure.data;

public class ReverseTest {

    public static void main(String[] args) {
        int reverse = reverse(2147483647);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int yushu = x % 10;
            x /= 10;
            boolean b = rev > Integer.MAX_VALUE / 10;
            if (b || (rev == Integer.MAX_VALUE / 10 && yushu > 7)) {
                System.out.println( b+ " 1 " + rev);
                return 0;
            }
            boolean b1 = rev < Integer.MIN_VALUE / 10;
            if (b1 || (rev == Integer.MIN_VALUE / 10 && yushu < -8)) {
                System.out.println("2");
                return 0;
            }
            rev = rev * 10 + yushu;
        }
        return rev;
    }
}
