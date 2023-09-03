package cn.sepiggy.题解.二叉树.遍历.lc226;

/**
 * lc226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 * 遍历的思维模式:
 * 1) 遍历每个节点是否能解决问题？只要把二叉树上的每一个节点的左右子节点进行交换，最后的结果就是完全翻转之后的二叉树
 * 2) 单独抽出一个节点，需要让它做什么？让它把自己的左右子节点交换一下
 * 3) 需要在什么时候做？好像前中后序位置都可以
 */
class Solution {

    // 主函数
    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        /**** 前序位置 ****/
        // 每一个节点需要做的事就是交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历框架，去遍历左右子树的节点
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