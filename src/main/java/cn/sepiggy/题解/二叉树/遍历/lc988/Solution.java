package cn.sepiggy.题解.二叉树.遍历.lc988;

import java.util.ArrayList;
import java.util.List;

/**
 * lc988. 从叶结点开始的最小字符串
 * https://leetcode.cn/problems/smallest-string-starting-from-leaf/
 */
class Solution {

	List<Integer> curPathList = new ArrayList<>();
	String res;

	public String smallestFromLeaf(TreeNode root) {
		traverse(root);
		return res;
	}

	private void traverse(TreeNode root) {

		if (root == null) {
			return;
		}

		// 前序位置
		curPathList.add(root.val);
		// 判断是否是叶子节点
		if (root.left == null && root.right == null) {
			// 比较当前路径代表的字符串和最终结果返回值
			compare(curPathList);
		}
		traverse(root.left);
		traverse(root.right);
		// 后序位置
		curPathList.remove(curPathList.size() - 1);
	}

	private void compare(List<Integer> curPathList) {

		StringBuilder sb = new StringBuilder();
		for (int i = curPathList.size() - 1; i > -1; i--) {
			Integer nodeVal = curPathList.get(i);
			char c = (char) ('a' + (nodeVal - 0));
			sb.append(c);
		}

		String s = sb.toString();

		if (res == null || res.length() == 0) {
			res = s;
		} else {
			if (s.compareTo(res) < 0) {
				res = s;
			}
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}