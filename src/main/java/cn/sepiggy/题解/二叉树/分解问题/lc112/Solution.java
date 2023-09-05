package cn.sepiggy.题解.二叉树.分解问题.lc112;


/**
 * lc112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 */
class Solution {

	// 递归函数定义
	// 以root为根到叶子节点是否存在一条路径它的和为targetSum
	public boolean hasPathSum(TreeNode root, int targetSum) {

		/*** 当前节点要干的事情 ***/
		// 如果当前节点是空
		if (root == null) {
			return false;
		}

		// 如果当前节点是叶子节点
		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}

		/*** 递归调用 ***/
		return this.hasPathSum(root.left, targetSum - root.val) ||
				this.hasPathSum(root.right, targetSum - root.val);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}