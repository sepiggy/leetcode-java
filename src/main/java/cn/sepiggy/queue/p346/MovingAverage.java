package cn.sepiggy.queue.p346;

import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {

    private Queue<Integer> queue;
    private int queueMaxSize;
    private double sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        queueMaxSize = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == queueMaxSize) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */