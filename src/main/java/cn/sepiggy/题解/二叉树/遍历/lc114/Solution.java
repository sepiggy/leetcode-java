package cn.sepiggy.题解.二叉树.遍历.lc114;

/**
 * lc114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-cbce8/#%E7%AC%AC%E4%B8%89%E9%A2%98%E3%80%81%E5%B0%86%E4%BA%8C%E5%8F%89%E6%A0%91%E5%B1%95%E5%BC%80%E4%B8%BA%E9%93%BE%E8%A1%A8
 * 使用遍历的思维模式解题失败
 */
class Solution {

    TreeNode dummyNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode p = dummyNode;

    public void flatten(TreeNode root) {

        traverse(root);
        root = dummyNode.right;
    }

    void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        p.left = null;
        p.right = new TreeNode(root.val);
        p = p.right;

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