package cn.sepiggy.array.p27;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/
 */
class Solution {

    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        final int[] ints = {3, 2, 2, 3};
        final int i = removeElement(ints, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}