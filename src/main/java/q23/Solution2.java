package q23;

import common.ListNode;

/**
 * connect to one list, then merge sort
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            p.next = lists[i];
            while (lists[i].next != null) {
                lists[i] = lists[i].next;
            }
            p = lists[i];
        }
        return merge(head.next);
    }

    public ListNode merge(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p1 = newHead;
        ListNode p2 = newHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode right = merge(p1.next);
        p1.next = null;
        ListNode left = merge(head);

        ListNode result = new ListNode(0);
        ListNode p = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null)
            p.next = left;
        if (right != null)
            p.next = right;

        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().mergeKLists(new ListNode[]{}));
        System.out.println(new Solution2().mergeKLists(new ListNode[]{
                ListNode.getList(new int[]{1, 4, 5}),
                ListNode.getList(new int[]{1, 2, 8}),
                ListNode.getList(new int[]{3})
        }));
//        System.out.println(ListNode.getList(new int[]{1, 4, 5, 1, 2, 8, 3}));
//        System.out.println(new Solution2().merge(ListNode.getList(new int[]{1, 4, 5, 1, 2, 8, 3})));
    }
}
