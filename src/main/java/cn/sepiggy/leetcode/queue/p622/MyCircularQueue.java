package cn.sepiggy.leetcode.queue.p622;

// 参考bobo老师代码
// 循环队列
// 引入front和rear下标
// front: 队首索引
// rear: 队尾索引的下一个位置 (也就是待插入下一个元素的位置)
// front == rear -> 队列为空
// (rear + 1) % data.length == front -> 队列为满
// 因此在循环队列中, 有意浪费一个位置来区分空和满两种状态
class MyCircularQueue {

    private int[] data;
    private int front, rear; // front: 队首位置; rear: 队尾位置+1
    private int size; // 队列中实际元素个数

    /**
     * 构造器，设置队列长度为 k
     *
     * @param k
     */
    public MyCircularQueue(int k) {
        data = new int[k + 1]; // 用户期望的容量 + 1 = 实际底层数组需要的容量
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        size--;
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     *
     * @return
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     *
     * @return
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear - 1 + data.length) % data.length;
        return data[index];
    }

    /**
     * 检查循环队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 检查循环队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */