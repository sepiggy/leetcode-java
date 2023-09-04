package cn.sepiggy.题解.二叉树.遍历.lc144;

import java.util.ArrayList;
import java.util.List;

/**
 * lc144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 */
class Solution {

    private List<Integer> res = new ArrayList<>();

    // 返回前序遍历结果
    public List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
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