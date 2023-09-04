package cn.sepiggy.题解.二叉树.分解问题.lc144;

import java.util.LinkedList;
import java.util.List;

/**
 * lc144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=685#/detail/pc?id=6695
 * 分解问题：一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果
 */
class Solution {

    // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraversal(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraversal(root.right));

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