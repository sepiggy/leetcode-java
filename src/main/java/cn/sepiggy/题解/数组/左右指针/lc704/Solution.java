package cn.sepiggy.题解.数组.左右指针.lc704;

class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;

        int leftPointer = 0;
        int rightPointer = len - 1;

        while (leftPointer <= rightPointer) {
            int midPointer = (leftPointer + rightPointer) / 2;
            if (nums[midPointer] < target) {
                leftPointer = midPointer + 1;
            } else if (nums[midPointer] > target) {
                rightPointer = midPointer - 1;
            } else {
                return midPointer;
            }
        }

        return -1;
    }
}