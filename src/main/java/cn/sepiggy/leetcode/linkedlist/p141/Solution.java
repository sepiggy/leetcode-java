package cn.sepiggy.leetcode.linkedlist.p141;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，链表有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}