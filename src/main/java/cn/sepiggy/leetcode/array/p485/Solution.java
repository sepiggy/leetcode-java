package cn.sepiggy.leetcode.array.p485;

/**
 * https://leetcode.cn/problems/max-consecutive-ones/
 */
class Solution {

	public int findMaxConsecutiveOnes(int[] nums) {

		int res = 0;
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] == 1) {
				fast++;
				res = Math.max(fast - slow, res);
			} else {
				fast++;
				slow = fast;
			}
		}
		return res;
	}
}