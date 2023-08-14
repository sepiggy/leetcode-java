package cn.sepiggy.剑指offer第2版.linkedlist.p22;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    // 倒数第k个节点，正数第n-k+1个节点
    // 从第一个节点开始需要走n-k步到第n-k+1个节点
    // 因为不知道n有多大，先让一个指针走k步
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        ListNode p2 = head;

        // 先让p1走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        // 再让p1和p2同时走到头，这时都走了n-k步
        // p2指向第n-k+1个节点，也就是倒数第k个节点
        while(p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }
}