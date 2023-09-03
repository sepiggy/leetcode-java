package cn.sepiggy.题解.二叉树.遍历.lc662;

/**
 * lc662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
class Solution {
    int left = 0;
    int right = 0;

    public int widthOfBinaryTree(TreeNode root) {
        // TODO
        return 0;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

//        traverse(root.left);
//        left =
//        traverse(root.right);
//        right++;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}