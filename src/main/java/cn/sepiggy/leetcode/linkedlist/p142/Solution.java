package cn.sepiggy.leetcode.linkedlist.p142;

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

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slower = head;
        ListNode faster = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                ListNode runner = head;
                while (runner != slower) {
                    slower = slower.next;
                    runner = runner.next;
                }
                return runner;
            }
        }
        return null;
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