package cn.sepiggy.leetcode.loopinvariant.p203;

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

    public ListNode removeElements(ListNode head, int val) {

        ListNode visitNode = head;
        ListNode dummy = new ListNode();
        ListNode visitNode2 = dummy;
        while (visitNode != null) {
            if (visitNode.val != val) {
                visitNode2.next = visitNode;
            }

            visitNode = visitNode.next;
        }

        return dummy.next;
    }

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

}

