package q19;

import common.ListNode;

public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p1 = newHead;
        ListNode p2 = newHead;
        for (int i = 0; i <= n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().removeNthFromEnd(ListNode.getList(new int[]{}), 0));
    }
}
