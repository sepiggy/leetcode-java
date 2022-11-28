package cn.sepiggy.tree.leetcode.p572;

class Solution {

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val &&
                isSame(a.left, b.left) &&
                isSame(a.right, b.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == t || t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return s.val == t.val && isSame(s, t) ||
                isSubtree(s.left, t) ||
                isSubtree(s.right, t);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}