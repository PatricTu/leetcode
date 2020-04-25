package q23;

import common.ListNode;

/**
 * multiway merge with priority queue
 * TODO
 */
public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().mergeKLists(new ListNode[]{
                ListNode.getList(new int[]{}),
                ListNode.getList(new int[]{}),
                ListNode.getList(new int[]{})
        }));
    }
}
