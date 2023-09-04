package cn.sepiggy.题解.二叉树.遍历.lc617;

/**
 * lc617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 */
class Solution {
	/**
	 * 虽然输入的是两棵树的根节点，但它们的操作是同步的，所以完全可以看做在遍历一棵二叉树
	 * 关键是遍历的过程中，你要对每个节点做什么，其实也很简单，按照题目的要求将两棵二叉树的每个节点合并即可
	 *
	 * @param root1
	 * @param root2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

		// 如果一棵树有，另一棵树没有，接上去
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}

		// 两棵树都有的节点，叠加节点值
		root1.val += root2.val;

		// 递归合并左右子树
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);

		return root1;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}