package cn.sepiggy.leetcode.array.p1;

// TODO 双指针方法不可行，因为原数组不是有序数组
// TODO 报错
class Solution2 {

	public int[] twoSum(int[] nums, int target) {

		int len = nums.length;

		// 双指针
		int p1 = 0;
		int p2 = len - 1;

		while (true) {
			if (nums[p1] + nums[p2] == target) {
				break;
			} else if (nums[p1] + nums[p2] < target) {
				p1 += 1;
			} else {
				p2 -= 1;
			}
		}

		return new int[]{p1, p2};
	}

	public static void main(String[] args) {
		int[] nums = {-1, -2, -3, -4, -5};
		int target = -8;
		Solution2 solution2 = new Solution2();
		int[] ints = solution2.twoSum(nums, target);
		System.out.println("ints = " + ints);
	}
}