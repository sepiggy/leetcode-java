package cn.sepiggy.leetcode.tree.p515;

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

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.offer(root);
        }

        while (queue.size() != 0) {
            int n = queue.size();
            int levelMax = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                levelMax = Math.max(treeNode.val, levelMax);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            result.add(levelMax);
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