package cn.sepiggy.leetcode.array.p26;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
class Solution {

	public int removeDuplicates(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				slow++;
				// 维护 nums[0..slow] 无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 数组长度为索引 + 1
		return slow + 1;
	}

	public static void main(String[] args) {

	}
}