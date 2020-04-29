package com.liugs.datastructure.data;

public class KSmallUtil {

    public static void main(String[] args) {


    }

    public  ListNode middleNode(ListNode head) {
        // 看链表的第一瞬间 直接用List 得了
        boolean end = false;
        int length = 1;
        ListNode c = head;
        while (c.next != null) {
            ++length;
            c = c.next;
        }
        int result = length % 2 == 0 ? length / 2 + 1 : length / 2;
        boolean over = false;
        ListNode r = null;
        c = head;
        while (c.next != null && !over) {
            --result;
            if (result == 1) {
                over = true;
            }
            r = c.next;
        }
        return r;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
