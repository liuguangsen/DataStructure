package com.liugs.datastructure.data;

public class MatrixUtil {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(matrix);
        rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int y = 0;y < matrix.length;y++) {
            for (int x = 0;x < matrix.length;x++) {
                System.out.print(matrix[y][x] + "  ");
            }
            System.out.print("\n");
        }
    }

    public static void rotate(int[][] matrix) {
        int mSize = matrix.length;
        // 由题意其实就是移动的过程由外部层层外立面走
        int size = mSize / 2;

        // 转多少圈
        for (int length = 0; length < size; length++) {
            // 开始转圈 记录下首位置作为结束的记录
            int num = matrix[length][length];
            int temp = 0;

            boolean over = false;
            int currentx = length;
            int currenty = length;
            while (!over && currenty < mSize && currentx < mSize) {
                temp = matrix[currenty][currentx];
                matrix[currenty][currentx] = num;
                num = temp;
                System.out.println("num " + num + " " + currenty + " " + currentx);
                int[] next = getNext(currenty, currentx, length, mSize);
                System.out.println(next[1] + " " + next[0]);
                if (length == next[0] && length == next[1]) {
                    matrix[length][length] = num;
                    over = true;
                } else {
                    currentx = next[0];
                    currenty = next[1];
                }
            }

        }
    }

    private static int[] getNext(int x, int y, int length, int size) {
        // 写个算法获取下一个圈的点
        int[] re = new int[2];
        if (isInPath(x + 1, y, length, size)) {
            // 先往右边
            re[0] = x + 1;
            re[1] = y;
        } else if (isInPath(x, y + 1, length, size)) {
            // 先往下边
            re[0] = x;
            re[1] = y + 1;
        } else if (isInPath(x - 1, y, length, size)) {
            // 先往左边
            re[0] = x - 1;
            re[1] = y;
        } else if (isInPath(x, y - 1, length, size)) {
            // 先往上边
            re[0] = x;
            re[1] = y - 1;
        }
        System.out.println("getNext " + re[0] + " " + re[1] + " " + length + " " + size);
        return re;
    }

    private static boolean isInPath(int x, int y, int length, int size) {
        System.out.println("isInPath " + x + " " + y + " " + length + " " + size);
        // 检测这个点是不是在圈上
        // 左右上下都检查下
        boolean left = x == length;
        boolean right = size - 1 - x == length;
        boolean top = y == length;
        boolean bottom = size - 1 - y == length;
        boolean b = left || right
                || top || bottom;
        return b && x < size && y < size && x >= 0 && y >= 0;
    }
}
