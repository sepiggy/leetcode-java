package cn.sepiggy.题解.二叉树.遍历.lc1457;

import java.util.ArrayList;
import java.util.List;

/**
 * lc1457. 二叉树中的伪回文路径
 * https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * // TODO 此种解法超时
 */
class Solution {

	int res = 0;
	List<Integer> curPath = new ArrayList<>();

	public int pseudoPalindromicPaths(TreeNode root) {

		traverse(root);
		return res;
	}

	private void traverse(TreeNode root) {

		if (root == null) {
			return;
		}

		curPath.add(root.val);
		// 叶子节点
		if (root.left == null && root.right == null) {
			doJudge(curPath);
		}
		traverse(root.left);
		traverse(root.right);
		curPath.remove(curPath.size() - 1);
	}

	private void doJudge(List<Integer> curPath) {

		// 题目说了 1 <= root.val <= 9，所以我们可以用一个大小为 10 的 count 数组做计数器来记录每条路径上的元素出现次数，到达叶子节点之后根据元素出现的次数判断是否可以构成回文串。
		int[] count = new int[10];

		for (int i = 0; i < curPath.size(); i++) {
			Integer nodeVal = curPath.get(i);
			count[nodeVal]++;
		}

		// 如果路径上出现奇数次的数字个数大于 1，
		// 则不可能组成回文串，反之则可以组成回文串
		int odd = 0;
		for (int i : count) {
			if (i % 2 == 1) {
				odd++;
			}
		}
		if (odd <= 1) {
			res++;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}