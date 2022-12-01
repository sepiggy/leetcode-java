package cn.sepiggy.leetcode.hashtable.p652;

import java.util.*;

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

    Map<String, TreeNode> treeNodeMap = new HashMap<>();

    // 记录已经被访问的节点的key
    Set<String> keySet = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        visitTreeNode(root);
        return new ArrayList<>(treeNodeMap.values());
    }

    private String visitTreeNode(TreeNode node) {
        if (node == null) {
            return "";
        }
        // 设计的key要体现左右子树的顺序同时要体现null节点
        String treeNodeKey = node.val
                + "("
                + visitTreeNode(node.left)
                + ","
                + visitTreeNode(node.right)
                + ")";

        // Set和Map结合使用
        if (!keySet.add(treeNodeKey)) {
            treeNodeMap.put(treeNodeKey, node);
        }
        return treeNodeKey;
    }


    static final class TreeNode {
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