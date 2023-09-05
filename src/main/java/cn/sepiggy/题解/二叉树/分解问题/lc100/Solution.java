package cn.sepiggy.题解.二叉树.分解问题.lc100;

/**
 * lc100. 相同的树
 * https://leetcode.cn/problems/same-tree/description/
 */
class Solution {

	// 递归函数定义：
	// 当前节点是否相同 + 左右子树是否相同
	public boolean isSameTree(TreeNode p, TreeNode q) {

		/*** 当前节点 ***/
		if (p == null && q == null) { // p和q都为空
			return true;
		}

		if (p == null || q == null) { // p和q只能有一个空
			return false;
		}

		if (p.val != q.val) { // p和q都不为空
			return false;
		}

		/*** 递归调用 ***/
		return isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}