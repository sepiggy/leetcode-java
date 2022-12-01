package cn.sepiggy.leetcode.hashtable.p706;

class MyHashMap {

    static final int BUCKET_SIZE = 1 << 10;

    Node[] buckets;

    public MyHashMap() {
        buckets = new Node[BUCKET_SIZE];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        final int getResult = get(key);
        final int bucketIndex = hash(key);
        if (getResult != -1) {
            Node visitNode = buckets[bucketIndex];
            while (visitNode != null) {
                if (visitNode.key == key) {
                    visitNode.val = value;
                    return;
                }
                visitNode = visitNode.next;
            }
        } else {
            Node visitNode = buckets[bucketIndex];
            while (visitNode.next != null) {
                visitNode = visitNode.next;
            }
            visitNode.next = new Node(key, value);
            return;
        }
    }

    public int get(int key) {
        final int bucketIndex = hash(key);
        Node visitNode = buckets[bucketIndex];
        while (visitNode != null) {
            if (visitNode.key == key) {
                return visitNode.val;
            }
            visitNode = visitNode.next;
        }
        return -1;
    }

    public void remove(int key) {
        final int getResult = get(key);
        final int bucketIndex = hash(key);
        if (getResult == -1) {
            return;
        } else {
            Node visitNode = buckets[bucketIndex];
            while (visitNode.next != null && visitNode.next.key != key) {
                visitNode = visitNode.next;
            }
            visitNode.next = visitNode.next.next;
            return;
        }
    }

    int hash(int key) {
        return key % BUCKET_SIZE;
    }

    static final class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */