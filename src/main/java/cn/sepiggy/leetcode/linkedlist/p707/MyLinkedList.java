package cn.sepiggy.leetcode.linkedlist.p707;

class MyLinkedList {

    Node head;

    public MyLinkedList() {
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {

        if (head == null) {
            return -1;
        }

        Node currentNode = head;

        for (int i = 0; i < index && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            return currentNode.val;
        } else {
            return -1;
        }
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {

        final Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node tailNode = head;

        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }

        tailNode.next = newNode;
    }

    /**
     * addAtIndex(index,val)：
     * 在链表中的第 index 个节点之前添加值为 val 的节点。 (在第index-1个元素之后添加)
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果 index 小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val), visitor = head;
        int visitorIndex = 0;

        while (visitor != null && visitorIndex != (index - 1)) {
            visitor = visitor.next;
            visitorIndex++;
        }

        if (visitor == null) {
            return;
        }

        newNode.next = visitor.next;
        visitor.next = newNode;
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {

        if (head == null) {
            return;
        }

        if (index == 0) {
            Node deletedNode = head;
            head = deletedNode.next;
            deletedNode.next = null;
            return;
        }

        Node visitor = head;

        for (int i = 0; i < index - 1 && visitor.next != null; i++) {
            visitor = visitor.next;
        }

        if (visitor.next == null) {
            return;
        }

        Node deletedNode = visitor.next;
        visitor.next = deletedNode.next;
        deletedNode.next = null;
        return;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    @Override
    public String toString() {

        if (head == null) {
            return "[]";
        }
        if (head.next == null) {
            return head.val + "->null";
        }
        StringBuilder sb = new StringBuilder();
        Node visitor = head;
        while (visitor.next.next != null) {
            sb.append(visitor.val);
            sb.append("->");
            {
                visitor = visitor.next;
            }
        }
        sb.append(visitor.val);
        sb.append("->");
        sb.append(visitor.next.val);
        sb.append("->null");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
//        myLinkedList.addAtIndex(1, 30);

        System.out.println(myLinkedList);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */