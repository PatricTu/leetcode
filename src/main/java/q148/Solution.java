package q148;
import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;

        int size = 0;
        ListNode pn = head;
        while (pn != null) {
            size++;
            pn = pn.next;
        }
        if (size <= 1)
            return head;

        pn = head;
        for (int i = 0; i < size / 2 - 1; i++) {
            pn = pn.next;
        }
        ListNode tail = pn.next;
        pn.next = null;

        ListNode sortedHead = sortList(head);
        ListNode sortedTail = sortList(tail);
        ListNode resultList = new ListNode(0);
        ListNode p = resultList;
        while (sortedHead != null && sortedTail != null) {
            if (sortedHead.val < sortedTail.val) {
                p.next = sortedHead;
                sortedHead = sortedHead.next;
            } else {
                p.next = sortedTail;
                sortedTail = sortedTail.next;
            }
            p = p.next;
        }
        if (sortedHead == null) {
            p.next = sortedTail;
        } else {
            p.next = sortedHead;
        }
        return resultList.next;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 3, 5};
        ListNode sortedList = new Solution().sortList(ListNode.getList(a));
        while (sortedList != null) {
            System.out.println(sortedList.val);
            sortedList = sortedList.next;
        }
    }
}