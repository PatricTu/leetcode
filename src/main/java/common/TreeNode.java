package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTree(Integer[] array) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        q.add(root);
        int i = 0;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (++i >= array.length || array[i] == null) {
                n.left = null;
            } else {
                n.left = new TreeNode(array[i]);
                q.add(n.left);
            }
            if (++i >= array.length || array[i] == null) {
                n.right = null;
            } else {
                n.right = new TreeNode(array[i]);
                q.add(n.right);
            }
        }
        return root;
    }
}
