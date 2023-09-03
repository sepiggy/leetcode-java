package cn.sepiggy.题解.二叉树.分解问题.lc104;

/**
 * lc104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * 递归函数 + 返回值解法
 */
class Solution {

    // 一棵二叉树的最大深度可以通过子树的最大深度推导出来
    // 递归函数：输入根节点，返回这棵二叉树的最大深度
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;

        return res;
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