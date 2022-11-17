package cn.sepiggy.linkedlist.p146;

class LRUCache {

    DoublyList doublyList;
    int capacity;

    public LRUCache(int capacity) {
        this.doublyList = new DoublyList(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyListNode nodeByKey = doublyList.getNodeByKey(key);
        if (nodeByKey == null) {
            return -1;
        } else {
            return nodeByKey.val;
        }
    }

    public void put(int key, int val) {
        doublyList.put(key, val);
    }

    static class DoublyList {

        DoublyListNode head, tail;
        int capacity;
        int size;

        public DoublyList(int capacity) {
            this.capacity = capacity;
        }

        void put(int key, int val) {
            DoublyListNode nodeByKey = getNodeByKey(key);
            if (nodeByKey != null) {
                nodeByKey.val = val;
            } else {


            }
        }

        DoublyListNode getNodeByKey(int key) {
            DoublyListNode visitor = head;
            int counter = 0;
            while (visitor != null && counter < this.capacity) {
                if (visitor.key == key) {
                    return visitor;
                }
                visitor = visitor.next;
                counter++;
            }
            return null;
        }

        void addAtTail(int key, int val) {
            DoublyListNode newNode = new DoublyListNode(key, val);
            if (tail == null) {
                head = newNode;
                tail = newNode;
                size++;
                return;
            }
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }

        void addAtHead(int key, int val) {
            DoublyListNode newNode = new DoublyListNode(key, val);
            if (head == null) {
                head = newNode;
                tail = newNode;
                size++;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    static class DoublyListNode {
        // 值域
        int key;
        int val;
        // 指针域
        DoublyListNode prev, next;

        DoublyListNode(int key, int val) {
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