package cn.sepiggy.题解.二叉树.分解问题.lc101;


/**
 * lc101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return false;
		}

		return check(root.left, root.right);
	}

	// 如果一棵二叉树是对称的
	// 判断两棵树是否镜像对称，只要判断两棵子树都是镜像对称的就行了
	private boolean check(TreeNode left, TreeNode right) {

		if (left == null || right == null) {
			return left == right;
		}

		if (left.val != right.val) {
			return false;
		}

		return check(left.right, right.left) && check(left.left, right.right);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}