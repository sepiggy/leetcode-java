package cn.sepiggy.leetcode.array.p167;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
class Solution {
	public static int[] twoSum(int[] numbers, int target) {

		// 一左一右两个指针相向而行
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				// 题目要求的索引是从 1 开始的
				return new int[]{left + 1, right + 1};
			} else if (sum < target) {
				left++; // 让 sum 大一点
			} else if (sum > target) {
				right--; // 让 sum 小一点
			}
		}
		return new int[]{-1, -1};
	}

	public static void main(String[] args) {
		final int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(ints));
	}
}