package cn.sepiggy.模板.二叉树;

/**
 * 二叉树遍历框架
 */
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 二叉树遍历框架
    public void traverse(TreeNode root) {

        // base case
        if (root == null) {
            return;
        }

        // 前序遍历位置
        traverse(root.left);
        // 中序遍历位置
        traverse(root.right);
        // 后序遍历位置
    }
}
