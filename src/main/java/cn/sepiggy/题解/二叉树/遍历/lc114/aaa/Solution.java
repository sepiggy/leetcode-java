package cn.sepiggy.题解.二叉树.遍历.lc114.aaa;

/**
 * lc114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
class Solution {
	/**
	 * 递归函数定义：
	 * 将以root为根节点的二叉树展开为链表
	 *
	 * @param root
	 */
	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		// 左子树已经被拉平成一条链表
		flatten(root.left);
		TreeNode left = root.left;

		// 右子树已经被拉平成一条链表
		flatten(root.right);
		TreeNode right = root.right;

		root.left = null;
		root.right = left;

		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}