package cn.sepiggy.题解.链表.双指针.lc142.s2;

class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode() {
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // 快指针走两步，慢指针走一步
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) break;
        }

        // 上面的代码类似 hasCycle 函数
        if (fastPointer == null || fastPointer.next == null) {
            // fastPointer 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slowPointer = head;

        // 快慢指针同步前进，相交点就是环起点
        while (slowPointer != fastPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}
