package cn.sepiggy.题解.二叉树.分解问题.lc100;

/**
 * lc100. 相同的树
 * https://leetcode.cn/problems/same-tree/description/
 */
class Solution {
	//
	// 根节点相同
	// 根节点的左子树相同
	// 根节点的右子树相同
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		} else if (p == null && q == null) {
			return true;
		} else if (p.val != q.val) {
			return false;
		} else if (!isSameTree(p.left, q.left)) {
			return false;
		} else if (!isSameTree(p.right, q.right)) {
			return false;
		}

		return true;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}