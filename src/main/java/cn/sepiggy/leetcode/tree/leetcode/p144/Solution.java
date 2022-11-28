package cn.sepiggy.leetcode.tree.leetcode.p144;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> integers = new ArrayList<>();
        doPreorderTraversal(root, integers);
        return integers;
    }

    private void doPreorderTraversal(TreeNode root, List<Integer> ans) {
        // 边界处理：如果树为空，那么不需要处理
        if (root != null) {
            ans.add(root.val);
            doPreorderTraversal(root.left, ans);
            doPreorderTraversal(root.right, ans);
        }
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