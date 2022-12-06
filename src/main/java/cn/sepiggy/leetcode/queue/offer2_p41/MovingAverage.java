package cn.sepiggy.leetcode.queue.offer2_p41;

import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {

    Queue<Integer> numQueue;
    int capacity;
    int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        numQueue = new ArrayDeque<>();
        capacity = size;
    }

    public double next(int val) {
        numQueue.offer(val);
        sum += val;
        // 补偿
        if (numQueue.size() > capacity) {
            sum -= numQueue.poll();
        }

        return (double) sum / numQueue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */