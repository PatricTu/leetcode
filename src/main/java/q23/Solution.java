package q23;

import common.ListNode;

/**
 * multiway merge
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (true) {
            int minVal = Integer.MAX_VALUE;
            int minInd = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minInd = i;
                }
            }
            if (minInd == -1)
                break;
            p.next = lists[minInd];
            p = p.next;
            lists[minInd] = lists[minInd].next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeKLists(new ListNode[]{
                ListNode.getList(new int[]{}),
                ListNode.getList(new int[]{}),
                ListNode.getList(new int[]{})
        }));
    }
}
