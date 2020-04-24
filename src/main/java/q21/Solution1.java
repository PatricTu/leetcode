package q21;

import common.ListNode;

/**
 * recursive
 * TODO
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeTwoLists(ListNode.getList(new int[]{1, 2, 4}),
                ListNode.getList(new int[]{1, 3, 4})));
    }
}
