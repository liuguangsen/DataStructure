package com.liugs.datastructure.data;

public class LinkUtil {
    public static void main(String[] args) {
        ListNode f = new ListNode(1);
        ListNode s = new ListNode(2);
        ListNode t = new ListNode(3);
        ListNode fo = new ListNode(4);
        f.next = s;
        s.next = t;
        t.next = fo;
        ListNode reverse = reverse(f);

//        print(reverse);
    }

    private static void print(ListNode reverse) {
        ListNode p = reverse;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            print(curr);
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
