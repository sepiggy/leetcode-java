package cn.sepiggy.题解.二叉树.遍历.lc199;

import java.util.ArrayList;
import java.util.List;

/**
 * lc199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 * https://labuladong.github.io/algo/tree-class/100-dao-xi-083dc/qiang-hua--4549d/
 */
class Solution {

    List<Integer> res = new ArrayList<>();
    // 记录递归的层数
    int depth = 0;

    public List<Integer> rightSideView(TreeNode root) {

        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        if (res.size() < depth) {
            // 这一层还没有记录值
            // 说明 root 就是右侧视图的第一个节点
            res.add(root.val);
        }

        // 注意，这里反过来，先遍历右子树再遍历左子树
        // 这样首先遍历的一定是右侧节点
        traverse(root.right);
        traverse(root.left);
        // 后序遍历位置
        depth--;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}