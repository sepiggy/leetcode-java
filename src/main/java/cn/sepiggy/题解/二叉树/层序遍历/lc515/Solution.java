package cn.sepiggy.题解.二叉树.层序遍历.lc515;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * lc515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
 */
class Solution {

	List<Integer> result = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();

	public List<Integer> largestValues(TreeNode root) {

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			int levelMax = Integer.MIN_VALUE;

			for (int i = 0; i < levelSize; i++) {

				TreeNode treeNode = queue.poll();

				if (treeNode.val > levelMax) {
					levelMax = treeNode.val;
				}

				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}

				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}

			result.add(levelMax);
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}