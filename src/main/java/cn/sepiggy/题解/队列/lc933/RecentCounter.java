package cn.sepiggy.题解.队列.lc933;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * lc933. 最近的请求次数
 * https://leetcode.cn/problems/number-of-recent-calls/
 */
class RecentCounter {

	Queue<Integer> queue;
	int windowSize;

	public RecentCounter() {
		queue = new ArrayDeque<>();
		windowSize = 3000;
	}

	public int ping(int t) {

		queue.offer(t);
		// 这里使用while，因为可能不止一个元素出队
		while (t - queue.peek() > windowSize) {
			queue.poll();
		}
		return queue.size();
	}
}