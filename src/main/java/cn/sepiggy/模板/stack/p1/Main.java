package cn.sepiggy.模板.stack.p1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://labuladong.github.io/algo/2/23/63/
public class Main {

    /**
     * 输入一个数组 nums，请你返回一个等长的结果数组，结果数组中对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。
     *
     * @param nums
     * @return
     */
    int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        // 倒着往栈里放数据
        // for 循环要从后往前扫描元素，因为我们借助的是栈的结构，倒着入栈，其实是正着出栈。
        for (int i = len - 1; i > -1; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        Main main = new Main();
        int[] res = main.nextGreaterElement(nums);
        System.out.println("res = " + Arrays.toString(res));
    }
}
