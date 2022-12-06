package cn.sepiggy.leetcode.stack.p496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);

        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }

        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = len - 1; i > -1; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}