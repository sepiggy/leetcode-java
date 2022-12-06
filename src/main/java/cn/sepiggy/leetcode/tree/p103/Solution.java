package cn.sepiggy.leetcode.tree.p103;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.offer(root);
        }

        int j = 0;
        while (queue.size() > 0) {
            int n = queue.size();
            int[] levelArray = new int[n];

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                levelArray[i] = treeNode.val;
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            if (j % 2 == 0) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    temp.add(levelArray[i]);
                }
                result.add(temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                for (int i = n - 1; i > -1; i--) {
                    temp.add(levelArray[i]);
                }
                result.add(temp);
            }
            j++;
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