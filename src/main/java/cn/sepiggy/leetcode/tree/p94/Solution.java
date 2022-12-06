package cn.sepiggy.leetcode.tree.p94;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doInorder(root,ans);
        return ans;
    }

    private void doInorder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            doInorder(root.left, ans);
            ans.add(root.val);
            doInorder(root.right,ans);
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