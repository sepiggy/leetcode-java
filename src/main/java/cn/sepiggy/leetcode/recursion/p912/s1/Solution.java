package cn.sepiggy.leetcode.recursion.p912.s1;

import java.util.Arrays;

class Solution {

    public int[] sortArray(int[] nums) {

        int len = nums.length;
        // 辅助数组 (空间换时间)
        int[] temp = new int[len];

        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对 nums[left..right]位置进行归并排序
     *
     * @param nums  待排序的数组
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

        // 合并[left..mid]和[mid+1..right]两个有序区间
        // 全局使用temp数组用于归并的作用：
        // 1. 避免了复制nums[left..right]到temp[0..right-left]要处理的下标偏移问题
        // 2. 每一次归并都创建新的数组，创建和回收数组空间有性能开销
        // 将nums数组数据拷贝到temp数组对应的位置
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // i和j分别指向辅助数组两个有序区间[left..mid]和[mid+1..right]的第一个元素
        // k指向原始数组[left..right]中待排序的位置
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