package cn.sepiggy.leetcode.tree.p637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.offer(root);
        }

        while (queue.size() > 0) {
            int n = queue.size();
            double sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            double averageLevel = sum / n;
            result.add(averageLevel);
        }

        return result;
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