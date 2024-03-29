package cn.sepiggy.题解.二叉树.层序遍历.lc637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * lc637. 二叉树的层平均值
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/
 */
class Solution {

	List<Double> result = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();

	public List<Double> averageOfLevels(TreeNode root) {

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			double levelSum = 0.0;

			for (int i = 0; i < levelSize; i++) {
				TreeNode treeNode = queue.poll();
				levelSum += treeNode.val;

				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}

				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}

			result.add(levelSum / levelSize);
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}