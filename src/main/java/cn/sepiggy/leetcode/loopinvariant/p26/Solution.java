package cn.sepiggy.leetcode.loopinvariant.p26;


class Solution {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return len;
        }

        // 循环不变量：nums[0..j)有序，且元素唯一
        // j 表示下一个需要覆盖的元素的下标
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }


    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] nums = {1, 1, 2};
        final int result = solution.removeDuplicates(nums);
        System.out.println("result = " + result);
    }
}