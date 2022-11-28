package cn.sepiggy.tree.leetcode.p98;

class Solution {

    public boolean isValidBST(TreeNode root) {
        ans = true;
        preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }

    private boolean ans = true;

    private void preOrder(TreeNode root, Long l, Long r) {
        // 1. 如果为空树
        // 2. 如果已经有结点不满足BST的要求了
        if (root == null || !ans) {
            return;
        }
        // 检查当前结点是不是在影子二叉树的区间里面
        // 这里相当于在检查两棵二叉树相同位置的结点
        if (!(l < root.val && root.val < r)) {
            ans = false;
            return;
        }
        // 这里同时遍历左子树，(l, root.val)就是影子二叉树的左子结点
        preOrder(root.left, l, Long.valueOf(root.val));
        // 这里同时遍历右子树，(root.val, r)就是影子二叉树的右子结点
        preOrder(root.right, Long.valueOf(root.val), r);
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