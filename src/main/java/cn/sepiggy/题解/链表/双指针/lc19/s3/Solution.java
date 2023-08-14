package cn.sepiggy.题解.链表.双指针.lc19.s3;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

    // 删除链表的倒数第n个节点
    // 需要定位到链表的倒数第n+1个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 倒数第n+1个节点
        ListNode listNode = fetchNthFromEnd(dummyNode, n + 1);

        ListNode tmp = listNode.next;

        listNode.next = tmp.next;
        tmp = null;

        return dummyNode.next;
    }

    /*
     * 找到链表的倒数第k个节点
     * 倒数第k个节点就是链表的正数第n-k+1个节点
     * 从头节点走k步
     */
    private ListNode fetchNthFromEnd(ListNode head, int k) {

        ListNode p1 = head;
        ListNode p2 = head;

        // p1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        // p1,p2一起走n-k步
        // 此时p2指向走了n-k步，指向正数第n-k+1个节点
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}