package q2;

import common.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode p = resultHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode currentNode = new ListNode(sum % 10);
            p.next = currentNode;
            p = currentNode;
        }
        if (carry == 1)
            p.next = new ListNode(1);
        return resultHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addTwoNumbers(ListNode.getList(new int[]{2, 4, 3, 9, 9}), ListNode.getList(new int[]{5, 6, 7})));
    }
}
