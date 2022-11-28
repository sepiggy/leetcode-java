package cn.sepiggy.leetcode.queue.p933;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> queue;
    private static final int WINDOW_SIZE = 3000;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {

        // 入队条件为空
        queue.offer(t);

        // 出队条件 t - head > 3000
        while (t - queue.peek() > WINDOW_SIZE) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        final RecentCounter recentCounter = new RecentCounter();
        System.out.println("recentCounter.ping(642) = " + recentCounter.ping(642));
        System.out.println("recentCounter.ping(1849) = " + recentCounter.ping(1849));
        System.out.println("recentCounter.ping(4921) = " + recentCounter.ping(4921));
        System.out.println("recentCounter.ping(5936) = " + recentCounter.ping(5936));
        System.out.println("recentCounter.ping(5957) = " + recentCounter.ping(5957));
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */