package cn.sepiggy.题解.二叉树.遍历.lc1022;


import java.util.ArrayList;
import java.util.List;

/**
 * lc1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
class Solution {

	int res = 0;
	List<Integer> curPath = new ArrayList<>();

	public int sumRootToLeaf(TreeNode root) {

		traverse(root);
		return res;
	}

	private void traverse(TreeNode root) {

		if (root == null) {
			return;
		}

		curPath.add(root.val);
		if (root.left == null && root.right == null) {
			doSum(curPath);
		}
		traverse(root.left);
		traverse(root.right);
		curPath.remove(curPath.size() - 1);
	}

	private void doSum(List<Integer> curPath) {

		int number = 0;

		for (int i = 0; i < curPath.size(); i++) {
			number += Math.pow(2, curPath.size() - 1 - i) * curPath.get(i);
		}

		res += number;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}