package cn.sepiggy.leetcode.recursion.offer_p51.s2;

class Solution {
    public int reversePairs(int[] nums) {

        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] temp = new int[len];

        // 重载函数
        return reversePairs(nums, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) >>> 1;

        // 计算左边区间逆序对的总数
        int leftPairs = reversePairs(nums, left, mid, temp);
        // 计算右边区间逆序对的总数
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        // 计算跨越两个区间逆序对的总数
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);

        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1); // i == mid + 1 -> count = 0
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else {
                if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    j++;
                    count += (mid - i + 1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 5, 6, 4};
        int result = solution.reversePairs(nums);
        System.out.println("result = " + result);
    }
}