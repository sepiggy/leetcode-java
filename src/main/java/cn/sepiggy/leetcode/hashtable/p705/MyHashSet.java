package cn.sepiggy.leetcode.hashtable.p705;

class MyHashSet {

    Node[] nodes;

    static final int DEFAULT_SIZE = 1 << 14;

    public MyHashSet() {
        nodes = new Node[DEFAULT_SIZE];
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            nodes[i] = new Node(-1);
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        final int mod = key % DEFAULT_SIZE;
        Node visitNode = nodes[mod];
        while (visitNode.next != null) {
            visitNode = visitNode.next;
        }
        visitNode.next = new Node(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        final int mod = key % DEFAULT_SIZE;
        Node visitNode = nodes[mod];
        while (visitNode.next != null && visitNode.next.val != key) {
            visitNode = visitNode.next;
        }
        // 找到前一个节点
        if (visitNode.next.next == null) {
            visitNode.next = null;
        } else {
            Node node = visitNode.next.next;
            visitNode.next = node;
        }
    }

    public boolean contains(int key) {
        final int mod = key % DEFAULT_SIZE;
        Node visitNode = nodes[mod];
        while (visitNode != null) {
            if (visitNode.val == key) {
                return true;
            }
            visitNode = visitNode.next;
        }
        return false;
    }

    static final class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */