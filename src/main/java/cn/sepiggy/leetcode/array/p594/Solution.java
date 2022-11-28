package cn.sepiggy.leetcode.array.p594;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-harmonious-subsequence/
 */
class Solution {

	public static int findLHS(int[] nums) {

		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;

		while (left < right) {
			if (Math.abs(nums[left] - nums[right]) > 1) {
				left++;
				right--;
			} else {
				break;
			}
		}

		return right - left + 1;
	}

	public static void main(String[] args) {

		final int[] ints = {1, 3, 2, 2, 5, 2, 3, 7};
		final int result = findLHS(ints);
		System.out.println("result = " + result);
	}
}