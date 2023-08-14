package cn.sepiggy.题解.数组.双指针.lc27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < len) {

            if (nums[fastPointer] != val) {
                nums[slowPointer] = val;
                slowPointer++;
            }

            fastPointer++;
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution solution = new Solution();
        int i = solution.removeElement(nums, val);
        System.out.println("i = " + i);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

    }
}