package cn.sepiggy.leetcode.array.p1;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum/
 */
class Solution {

	public static int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					return new int[]{i, j};
				}
			}
		}

		return new int[]{-1, -1};
	}

	public static void main(String[] args) {
		final int[] ints = {2, 7, 11, 15};
		final int[] result = twoSum(ints, 9);
		System.out.println(Arrays.toString(result));
	}
}