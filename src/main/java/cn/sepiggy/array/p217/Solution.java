package cn.sepiggy.array.p217;

/**
 * https://leetcode.cn/problems/contains-duplicate/
 */
class Solution {

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int[] ints = {1, 2, 3, 1};
        System.out.println("containsDuplicate(ints) = " + containsDuplicate(ints));
    }
}