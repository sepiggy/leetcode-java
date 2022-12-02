package cn.sepiggy.leetcode.loopinvariant.p283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {

        int len = nums.length;

        // 循环不变量: 保证nums[0..j)的位置都是非0, nums[j..i)的位置都是0
        // j 指向了下一个要赋值的元素的位置
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        String result = Arrays.toString(nums);
        System.out.println("result = " + result);
    }
}