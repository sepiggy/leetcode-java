package cn.sepiggy.题解.二叉树.层序遍历.lc199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * lc199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 */
class Solution {

	List<Integer> result = new ArrayList<>();
	Queue<TreeNode> queue = new ArrayDeque<>();

	public List<Integer> rightSideView(TreeNode root) {

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {

				TreeNode treeNode = queue.poll();

				if (i == levelSize - 1) {
					result.add(treeNode.val);
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