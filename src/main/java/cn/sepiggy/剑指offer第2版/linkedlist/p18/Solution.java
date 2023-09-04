package cn.sepiggy.剑指offer第2版.linkedlist.p18;

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

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummyNode1 = new ListNode(Integer.MAX_VALUE);
        ListNode dummyNode2 = new ListNode(Integer.MAX_VALUE);

        dummyNode1.next = dummyNode2;
        dummyNode2.next = head;

        ListNode p1 = dummyNode1;
        ListNode p2 = dummyNode2;

        // p1指向待删除节点的前一个节点
        while (p2.next != null) {
            if (p2.val == val) {
                break;
            }

            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;

        return dummyNode2.next;
    }
}