package cn.sepiggy.题解.数组.快慢指针.lc283;

class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;

        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < len) {

            // 循环不变量: [0..slow) 区间中都是非零数字
            if (nums[fastPointer] != 0) {
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }

            fastPointer++;
        }

        for (int i = slowPointer; i < len; i++) {
            nums[i] = 0;
        }
    }
}