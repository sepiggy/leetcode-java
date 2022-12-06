package cn.sepiggy.leetcode.stack.p739;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;
        // 这里放元素索引，而不是元素
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];

        for (int i = len - 1; i > -1; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // 得到索引间距
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 将索引入栈，而不是元素
            stack.push(i);
        }

        return res;
    }
}