package q23;

import common.ListNode;

/**
 * 2-way merge
 */
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            head.next = merge(head.next, lists[i]);
        }
        return head.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
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
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().mergeKLists(new ListNode[]{
                ListNode.getList(new int[]{1, 4, 5}),
                ListNode.getList(new int[]{1, 2, 8}),
                ListNode.getList(new int[]{3})
        }));
    }
}
