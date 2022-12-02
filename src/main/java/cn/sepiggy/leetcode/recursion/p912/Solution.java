package cn.sepiggy.leetcode.recursion.p912;

import java.util.Arrays;

class Solution {

    public int[] sortArray(int[] nums) {

        int len = nums.length;
        // 辅助数组
        int[] temp = new int[len];

        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对 nums[left..right]位置进行归并排序
     *
     * @param nums  带排序的数组
     * @param left  待排序的开始区间
     * @param right 待排序的结束区间
     * @param temp  辅助数组
     */
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 递归终止条件
        if (left == right) {
            return;
        }

//        int mid = (left + (right - left) / 2);
        // 无符号右移
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 合并两个有序区间
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // i走到头剩下归并j
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // j走到头剩下归并i
                nums[k] = temp[i];
                i++;
            } else {
                if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 3, 1};
        solution.sortArray(nums);
        String result = Arrays.toString(nums);
        System.out.println("result = " + result);
    }
}