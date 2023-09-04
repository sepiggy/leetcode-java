package cn.sepiggy.题解.数组.快慢指针.lc27;

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
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }

            fastPointer++;
        }

        return slowPointer;
    }
}