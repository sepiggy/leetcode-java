package cn.sepiggy.题解.二叉树.遍历.lc404;

/**
 * lc404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 */
class Solution {

	int res = 0;

	public int sumOfLeftLeaves(TreeNode root) {

		traverse(root);
		return res;
	}

	private void traverse(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.left != null && root.left.left == null && root.left.right == null) {
			res += root.left.val;
		}
		traverse(root.left);
		traverse(root.right);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}