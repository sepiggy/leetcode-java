package cn.sepiggy.leetcode.recursion.p257;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        String s = sb.toString();
        String[] splits = s.split(",");

        for (int i = 0; i < splits.length; i++) {
            if (i == 0) {
                result.add(splits[0]);
            } else {
                result.add(root.val + "->" + splits[i]);
            }
        }

        return result;
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sb.append(",");
        } else {
            sb.append("->");
        }

        traverse(root.left, sb);
        traverse(root.right, sb);
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

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        List<String> stringList = solution.binaryTreePaths(root);

        stringList.forEach(System.out::println);
    }
}