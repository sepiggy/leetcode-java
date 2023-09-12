package cn.sepiggy.题解.二叉树.层序遍历.lc107;

import java.util.*;

/**
 * lc107. 二叉树的层序遍历II
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/
 */
class Solution {

	// 只有LinkedList才有addFirst方法, 而ArrayList没有
	LinkedList<List<Integer>> result = new LinkedList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			List<Integer> levelList = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {

				TreeNode treeNode = queue.poll();
				levelList.add(treeNode.val);

				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}

			result.addFirst(levelList);
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}