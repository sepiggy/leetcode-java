package cn.sepiggy.leetcode.recursion.p215;

import java.util.Arrays;

class Solution {

    int i, j, k = 0;
    int x;
    int result;

    public int findKthLargest(int[] nums, int x) {
        this.x = x;
        mergeSort(nums);
        return result;
    }

    public void mergeSort(int[] nums) {

        // 入函数调用栈
        // 对数组进行一分为二
        if (nums.length > 1) {
            final int mid = nums.length / 2;
            final int[] left = Arrays.copyOfRange(nums, 0, mid);
            final int[] right = Arrays.copyOfRange(nums, mid, nums.length);

            mergeSort(left);
            mergeSort(right);

            while (i < left.length && j < right.length) {
                int tmp;
                if (left[i] >= right[i]) {
                    i += 1;
                    tmp = left[i];
                } else {
                    j += 1;
                    tmp = right[j];
                }
                k += 1;
                if (k == x) {
                    result = tmp;
                    return;
                }
            }

            while (i < left.length) {
                i += 1;
                k += 1;
                if (k == x) {
                    result = left[i];
                    return;
                }
            }

            while (j < right.length) {
                j += 1;
                k += 1;
                if (k == x) {
                    result = right[j];
                    return;
                }
            }
        }
    }
}