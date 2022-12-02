package cn.sepiggy.leetcode.loopinvariant.p80;

class Solution {
    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        // 当数组长度 < 2, 其原有元素都保留
        if (len < 2) {
            return len;
        }

        // 循环不变量: 保证[0..j)中不存在连续两个相等的元素
        // 使用下标i进行遍历，下标j进行赋值，下标j-2进行比较
        // 从下标2开始赋值
        int j = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}