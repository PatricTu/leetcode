package q19;

import common.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        ListNode prev = null;
        while (p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (prev == null)
            return p1 == null ? null : p1.next;
        prev.next = p1.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeNthFromEnd(ListNode.getList(new int[]{}), 0));
    }
}
