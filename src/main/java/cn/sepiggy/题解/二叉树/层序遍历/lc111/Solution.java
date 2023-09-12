package cn.sepiggy.题解.二叉树.层序遍历.lc111;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * lc111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 * BFS 算法和 DFS（回溯）算法的一大区别就是，BFS 第一次搜索到的结果是最优的，这个得益于 BFS 算法的搜索逻辑，可见详细题解。
 */
class Solution {

	int result = 0;
	Queue<TreeNode> queue = new ArrayDeque<>();

	public int minDepth(TreeNode root) {

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {

			// 当前层数
			result++;

			for (int i = 0; i < queue.size(); i++) {

				TreeNode treeNode = queue.poll();

				if (treeNode.left == null && treeNode.right == null) {
					return result;
				}

				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}

				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}
		}

		return result;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}