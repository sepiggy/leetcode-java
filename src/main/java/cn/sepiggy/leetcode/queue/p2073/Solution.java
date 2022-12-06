package cn.sepiggy.leetcode.queue.p2073;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    Queue<Integer> queue = new LinkedList();

    public int timeRequiredToBuy(int[] tickets, int k) {

        int len = tickets.length;
        int[] temp = new int[len];
        int result = 0;

        for (int i = 0; i < len; i++) {
            temp[i] = tickets[i];
        }

        for (int i = temp[k]; i > 0; i--) {
            for (int j = 0; j < len; j++) {
                if (temp[j] > 0) {
                    queue.offer(1);
                    temp[j]--;
                }
                if (j == k && temp[j] == 0) {
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        return result;
    }
}