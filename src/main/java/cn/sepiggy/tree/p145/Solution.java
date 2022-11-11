package cn.sepiggy.tree.p145;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doPostOrder(root, ans);
        return ans;
    }

    private void doPostOrder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            doPostOrder(root.left, ans);
            doPostOrder(root.right, ans);
            ans.add(root.val);
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