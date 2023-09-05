package cn.sepiggy.题解.二叉树.分解问题.lc111;

/**
 * lc111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * // TODO: ERROR
 */
class Solution {
	/**
	 * 递归函数: 输入一个二叉树的根节点，返回这棵二叉树的最小深度
	 *
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);

		if (leftDepth != 0 && rightDepth != 0) {
			return Math.min(leftDepth, rightDepth) + 1;
		}
		return Math.max(leftDepth, rightDepth);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}