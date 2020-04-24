package q21;

import common.ListNode;

/**
 * Merge sort
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeTwoLists(ListNode.getList(new int[]{1, 2, 4}),
                ListNode.getList(new int[]{1, 3, 4})));
    }
}
