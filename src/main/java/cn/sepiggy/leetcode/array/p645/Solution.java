package cn.sepiggy.leetcode.array.p645;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/set-mismatch/
 */
class Solution {

	public static int[] findErrorNums(int[] nums) {

		int slow = 0, fast = 1;

		while (fast < nums.length) {
			if (nums[slow] + 1 == nums[fast]) {
				slow++;
				fast++;
			} else {
				//
				break;
			}

		}

		return new int[]{nums[fast], nums[fast] - 1};
	}

	public static void main(String[] args) {
		final int[] errorNums = findErrorNums(new int[]{1, 2, 2, 4});
		// final int[] errorNums = findErrorNums(new int[]{1, 2, 2});
		// final int[] errorNums = findErrorNums(new int[]{2, 2});
		System.out.println("Arrays.toString(errorNums) = " + Arrays.toString(errorNums));
	}
}