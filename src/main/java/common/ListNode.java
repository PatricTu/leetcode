package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode getList(int[] vals) {
        ListNode node = null;
        ListNode pn = null;
        for (int v : vals) {
            ListNode cn = new ListNode(v);
            if (node == null) {
                node = cn;
            } else {
                pn.next = cn;
            }
            pn = cn;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}