package cn.sepiggy.题解.数组.左右指针.lc167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int len = numbers.length;

        int leftPointer = 0;
        int rightPointer = len - 1;

        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];

            if (sum < target) {
                // sum需要变大
                leftPointer++;
            } else if (sum > target) {
                // sum需要变小
                rightPointer--;
            } else {
                // sum满足要求
                return new int[]{leftPointer + 1, rightPointer + 1};
            }
        }

        return new int[]{-1, -1};
    }
}