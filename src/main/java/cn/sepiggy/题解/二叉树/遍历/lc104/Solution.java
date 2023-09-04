package cn.sepiggy.题解.二叉树.遍历.lc104;

/**
 * lc104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * 遍历函数 + 外部变量解法
 */
class Solution {

    // 记录最大深度
    int res = 0;

    // 记录当前遍历到的节点的深度
    int depth = 0;

    // 主函数
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历函数
    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        // 前序位置
        depth++;

        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        depth--;
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