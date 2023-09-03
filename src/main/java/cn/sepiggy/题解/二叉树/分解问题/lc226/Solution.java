package cn.sepiggy.题解.二叉树.分解问题.lc226;

/**
 * lc226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 * 分解问题的思维模式：
 * 1) 尝试给 invertTree 函数赋予一个定义: 将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
 * 2) 思考，对于某一个二叉树节点 x 执行 invertTree(x)，你能利用这个递归函数的定义做点啥？
 * 可以用 invertTree(x.left) 先把 x 的左子树翻转，再用 invertTree(x.right) 把 x 的右子树翻转，最后把 x 的左右子树交换，这恰好完成了以 x 为根的整棵二叉树的翻转，即完成了 invertTree(x) 的定义
 */
class Solution {

    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // 用 invertTree(x.left) 先把 x 的左子树翻转，
        // 再用 invertTree(x.right) 把 x 的右子树翻转，
        // 最后把 x 的左右子树交换，这恰好完成了以 x 为根的整棵二叉树的翻转，即完成了 invertTree(x) 的定义
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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