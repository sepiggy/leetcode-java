package cn.sepiggy.linkedlist.p146.s1;

import java.util.HashMap;

class LRUCache {

    // key -> Node(key, val)
    HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    DoublyList cache;
    // 最大容量
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoublyList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, val);
    }

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key) {
        Node e = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(e);
        // 重新插到队尾
        cache.addLast(e);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val) {
        Node e = new Node(key, val);
        map.put(key, e);
        // 链表尾部就是最近使用的元素
        cache.addLast(e);
    }

    /* 删除某一个 key */
    private void deleteKey(int key) {
        Node e = map.get(key);
        // 从链表中删除
        cache.remove(e);
        // 从 map 中删除
        map.remove(key);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    static final class DoublyList {
        Node head, tail; // dummy
        int size;

        DoublyList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }

        // 在链表尾部添加节点 e，时间 O(1)
        void addLast(Node e) {
            e.prev = tail.prev;
            e.next = tail;
            tail.prev.next = e;
            tail.prev = e;
            size++;
        }

        // 删除链表中的 e 节点（e 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node e) {
            e.next.prev = e.prev;
            e.prev.next = e.next;
            e.next = null;
            e.prev = null;
            size--;
        }

        // 删除链表中第一个节点，并返回该节点，时间 O(1)
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }

    static final class Node {
        int key, val; // 值域
        Node prev, next; // 指针域

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */