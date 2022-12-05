package cn.sepiggy.leetcode.queue.p225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue1; // 用于存储栈内的元素
    Queue<Integer> queue2; // 作为入栈操作的辅助队列

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 最后入栈的元素进入queue2
        queue2.offer(x);
        // 向queue2中依次插入queue1中的元素
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换两个队列引用
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */