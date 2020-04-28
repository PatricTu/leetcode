package q24;

import common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = new ListNode(0);
        ahead.next = head;
        ListNode prev = ahead;
        ListNode p = head;
        while (p != null && p.next != null) {
            prev.next = p.next;
            p.next = p.next.next;
            prev.next.next = p;
            prev = p;
            p = p.next;
        }
        return ahead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().swapPairs(ListNode.getList(new int[]{})));
    }
}
