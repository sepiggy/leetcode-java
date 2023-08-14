package cn.sepiggy.leetcode.linkedlist.p23;

import java.util.PriorityQueue;

/**
 * 最小堆
 */
class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // 虚拟头节点
        ListNode dummyNode = new ListNode();
        ListNode p = dummyNode;

        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        // 将 k 个链表的头节点加入最小堆
        for (ListNode headNode : lists) {
            if (headNode != null) {
                pq.add(headNode);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                // 将该节点的下一个节点放入最小堆
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }

        return dummyNode.next;
    }
}