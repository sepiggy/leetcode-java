package cn.sepiggy.leetcode.recursion.p2;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;

        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);

        // 指针 p 负责构建新链表
        ListNode p = dummy;

        // 记录进位
        int carry = 0;

        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;

            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            // 处理进位情况
            carry = val / 10;
            val = val % 10;

            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }

        // 返回结果链表的头结点（去除虚拟头结点）
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

    public static void main(String[] args) {

        ListNode l1 = new ListNode(), l2 = new ListNode();

        {
            l1.val = 2;
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(9);
        }

        {
            l2.val = 5;
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);
            l2.next.next.next = new ListNode(9);
        }

        final Solution solution = new Solution();
        final ListNode listNode = solution.addTwoNumbers(l1, l2);

        ListNode visitNode = listNode;
        while (visitNode != null) {
            System.out.println(visitNode.val);
            visitNode = visitNode.next;
        }
    }
}