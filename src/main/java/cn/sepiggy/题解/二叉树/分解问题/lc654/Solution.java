package cn.sepiggy.题解.二叉树.分解问题.lc654;

import java.util.Arrays;

/**
 * lc654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 * https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-172f0/#%E6%9E%84%E9%80%A0%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91
 */
class Solution {
    // 定义:
    // 创建一个根节点，其值为 nums 中的最大值
    // 递归地在最大值 左边 的 子数组前缀上 构建左子树
    // 递归地在最大值 右边 的 子数组后缀上 构建右子树
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // 构造根节点
        TreeNode root = new TreeNode(nums[maxIndex]);

        // 递归调用构造左右子树
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));

        return root;
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