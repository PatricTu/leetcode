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
class Solution1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = slow;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;

        ListNode sortedHead = sortList(head);
        ListNode sortedTail = sortList(slow);
        ListNode resultList = new ListNode(0);
        ListNode pn = resultList;
        while (sortedHead != null && sortedTail != null) {
            if (sortedHead.val < sortedTail.val) {
                pn.next = sortedHead;
                sortedHead = sortedHead.next;
            } else {
                pn.next = sortedTail;
                sortedTail = sortedTail.next;
            }
            pn = pn.next;
        }
        if (sortedHead == null) {
            pn.next = sortedTail;
        } else {
            pn.next = sortedHead;
        }
        return resultList.next;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 3, 5};
        ListNode sortedList = new Solution1().sortList(ListNode.getList(a));
        while (sortedList != null) {
            System.out.println(sortedList.val);
            sortedList = sortedList.next;
        }
    }
}