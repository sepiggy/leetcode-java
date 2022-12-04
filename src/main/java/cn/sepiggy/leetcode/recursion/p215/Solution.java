package cn.sepiggy.leetcode.recursion.p215;

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        // 辅助数组
        int[] temp = new int[len];

        findKthLargest(nums, 0, len - 1, temp);

        return nums[k - 1];
    }

    /**
     * 对nums[left..right]进行从大到小归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     */
    private void findKthLargest(int[] nums, int left, int right, int[] temp) {

        // 递归终止条件
        if (left == right) {
            return;
        }

        int mid = (left + right) >>> 1;

        findKthLargest(nums, left, mid, temp);
        findKthLargest(nums, mid + 1, right, temp);

        merge(nums, left, mid, right, temp);
    }

    /**
     * 合并temp[left..mid]和temp[mid+1..right]两个区间至nums[left..right]
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] >= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println("kthLargest = " + kthLargest);
    }
}