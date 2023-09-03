package cn.sepiggy.题解.二叉树.遍历.lc257;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lc257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/description/
 */
class Solution {

    List<String> res = new ArrayList<>();
    List<Integer> curPath = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        curPath.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            String leafPath = curPath.stream().map(String::valueOf).collect(Collectors.joining("->"));
            res.add(leafPath);
        }
        traverse(root.left);
        traverse(root.right);
        curPath.remove(curPath.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}