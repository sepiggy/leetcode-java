package cn.sepiggy.题解.二叉树.分解问题.lc114;

/**
 * lc114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-cbce8/#%E7%AC%AC%E4%B8%89%E9%A2%98%E3%80%81%E5%B0%86%E4%BA%8C%E5%8F%89%E6%A0%91%E5%B1%95%E5%BC%80%E4%B8%BA%E9%93%BE%E8%A1%A8
 * 使用分解问题的思维模式:
 * 1) 函数定义：输入节点root, 然后以root为根的二叉树就会被拉平为一条链表
 * 2) 有了这个函数定义，如何按题目要求把一棵树拉平成一条链表？
 * 对于一个节点 x，可以执行以下流程：
 * 2.1) 先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平
 * 2.2) 将 x 的右子树接到左子树下方，然后将整个左子树作为右子树
 */
class Solution {

    // 函数定义：输入节点root, 然后以root为根的二叉树就会被拉平为一条链表
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // 将左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
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