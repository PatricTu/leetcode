package q25;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ahead = new ListNode(0);
        ahead.next = head;
        ListNode prev = ahead;
        ListNode p = ahead.next;
        while (true) {
            int n = k;
            ListNode nextPart = p;
            while (nextPart != null && n > 0) {
                n--;
                nextPart = nextPart.next;
            }
            if (n > 0)
                break;
            ListNode reverseHead = p;
            ListNode node1 = reverseHead.next;
            ListNode node2 = reverseHead.next;
            while (node1 != nextPart) {
                node2 = node2.next;
                node1.next = reverseHead;
                reverseHead = node1;
                node1 = node2;
            }
            prev.next = reverseHead;
            prev = p;
            p.next = nextPart;
            p = nextPart;
        }
        return ahead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseKGroup(ListNode.getList(new int[]{1, 2, 3, 4, 5, 6}), 3));
    }
}
