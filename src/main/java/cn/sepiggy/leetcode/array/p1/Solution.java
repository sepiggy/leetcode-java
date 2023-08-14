package cn.sepiggy.leetcode.array.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表的解法: 以数组值作为key, 以数组下标作为value
 */
class Solution {
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{i, map.get(target - nums[i])};
			} else {
				map.put(nums[i], i);
			}
		}

		return null;
	}
}