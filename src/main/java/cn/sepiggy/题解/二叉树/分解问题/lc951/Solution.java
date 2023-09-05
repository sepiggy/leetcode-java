package cn.sepiggy.题解.二叉树.分解问题.lc951;

class Solution {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {

		if (root1 == null || root2 == null) {
			return root1 == root2;
		}

		if (root1.val != root2.val) {
			return false;
		}

		return flipEquiv(root1.left, root2.left);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}