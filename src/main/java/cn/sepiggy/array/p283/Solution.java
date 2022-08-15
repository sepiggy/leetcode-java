package cn.sepiggy.array.p283;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/
 */
class Solution {

	public static void moveZeroes(int[] nums) {
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		for (int p = slow; p < nums.length; p++) {
			nums[p] = 0;
		}
	}

	public static void main(String[] args) {
		final int[] ints = {0, 1, 0, 3, 1, 2};
		moveZeroes(ints);
		System.out.println(Arrays.toString(ints));
	}
}