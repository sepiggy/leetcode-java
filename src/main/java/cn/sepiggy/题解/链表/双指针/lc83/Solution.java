package cn.sepiggy.题解.链表.双指针.lc83;

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
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null) {

            if (fastPointer.val != slowPointer.val) {
                slowPointer = slowPointer.next;
                slowPointer.val = fastPointer.val;
            }

            fastPointer = fastPointer.next;
        }

        slowPointer.next = null;

        return head;
    }
}