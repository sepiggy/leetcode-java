package cn.sepiggy.题解.二叉树.分解问题.lc105;

/**
 * lc105. 从前序与中序遍历序列构造二叉树
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO
        return null;
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