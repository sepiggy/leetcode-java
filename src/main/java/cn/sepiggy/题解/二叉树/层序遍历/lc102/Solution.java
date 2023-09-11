package cn.sepiggy.题解.二叉树.层序遍历.lc102;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * lc102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
class Solution {

	List<List<Integer>> result = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();

	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root != null) { // 从上到下遍历
			queue.offer(root);
		}

		while (!queue.isEmpty()) { // 每层从左到右遍历

			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();

			for (int i = 0; i < size; i++) {

				TreeNode treeNode = queue.poll();
				levelList.add(treeNode.val);

				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}

				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}

			result.add(levelList);
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}