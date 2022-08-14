package cn.sepiggy.linkedlist.p19;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
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

    static ListNode arrayToLinkedList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i : arr) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return dummy.next;
    }

    static void printLinkedList(ListNode head) {
        ListNode p = head;
        String str = "";
        while (p != null) {
            str += p.val + "->";
        }
        System.out.println(str);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;

        int cnt = 1;

        // 遍历到正数第n个节点
        while (p1.next != null) {
            p1 = p1.next;
            cnt = cnt + 1;
            if (cnt >= n + 1) {
                p2 = p2.next;
            }
        }

        // 此时p2指向倒数第n个结点的前节点
        p2.next = p2.next.next;

        return head;
    }

    public static void main(String[] args) {
        final ListNode head = arrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        final ListNode listNode = removeNthFromEnd(head, 2);
        printLinkedList(listNode);
    }
}