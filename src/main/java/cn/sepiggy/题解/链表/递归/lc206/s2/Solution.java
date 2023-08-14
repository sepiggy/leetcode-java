package cn.sepiggy.题解.链表.递归.lc206.s2;

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

    // eg. 1->2->3->4->5->null
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 1->2<-3<-4<-5
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        // 避免链表出现环
        head.next = null;

        return newHead;
    }

    private static final class ListNode {
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
}