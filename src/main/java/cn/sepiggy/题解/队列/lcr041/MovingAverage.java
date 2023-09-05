package cn.sepiggy.题解.队列.lcr041;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * lcr041. 数据流中的移动平均值
 * https://leetcode.cn/problems/qIsx9U/
 */
class MovingAverage {

	Queue<Integer> queue;
	int windowSize;
	int sum;

	public MovingAverage(int size) {
		queue = new ArrayDeque<>();
		windowSize = size;
	}

	public double next(int val) {

		queue.offer(val);
		sum += val;
		if (queue.size() > windowSize) {
			sum -= queue.poll();
		}

		return (double) sum / queue.size();
	}
}