package cn.sepiggy.leetcode.recursion.offer_p51.s1;

/**
 * 暴力解法
 * 时间复杂度：O(N^2) 会超时
 */
class Solution {
    public int reversePairs(int[] nums) {

        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}