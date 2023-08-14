package cn.sepiggy.题解.数组.双指针.lc26;

class Solution {
    public int removeDuplicates(int[] nums) {

        // 判空处理
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        // 初始化快慢指针
        int slowPointer = 0;
        int fastPointer = 0;

        while (fastPointer < len) {

            if (nums[fastPointer] != nums[slowPointer]) {
                // 慢指针先移动，再赋值
                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
            fastPointer++;
        }

        return slowPointer + 1;
    }
}