package cn.sepiggy.leetcode.linkedlist.p19.s1;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
class Solution {

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

        static ListNode fromArray(int[] arr) {
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            for (int i : arr) {
                p.next = new ListNode(i);
                p = p.next;
            }
            return dummy.next;
        }

        @Override
        public String toString() {
            ListNode p = this;
            String str = "";
            while (p != null) {
                str += p.val + "->";
                p = p.next;
            }
            return str.substring(0, str.lastIndexOf("->"));
        }
    }

    // 主函数
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 解法中在链表头部接一个虚拟节点 dummy 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 dummy 节点并不影响尾部倒数第 k 个元素是什么。
        // 虚拟头结点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }

    public static void main(String[] args) {
        final ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        final ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
}