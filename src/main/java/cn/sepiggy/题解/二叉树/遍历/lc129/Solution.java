package cn.sepiggy.题解.二叉树.遍历.lc129;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    int res = 0;
    List<Integer> curPath = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        curPath.add(root.val);
        // 判断是否是叶子节点
        if (root.left == null && root.right == null) {
            String leafStr = curPath.stream().map(String::valueOf).collect(Collectors.joining());
            int leafNum = Integer.valueOf(leafStr);
            res += leafNum;
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