package cn.sepiggy.leetcode.loopinvariant.p27;

class Solution {

    public int removeElement(int[] nums, int val) {

        int len = nums.length;

        // 循环不变量: 保证nums[0..j)中不包含val
        // j指向下一个待赋值元素的位置
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++; // j指向下一个元素
            }
        }

        return j;
    }
}