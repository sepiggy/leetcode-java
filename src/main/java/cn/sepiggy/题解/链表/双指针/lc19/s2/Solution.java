package cn.sepiggy.题解.链表.双指针.lc19.s2;


// 虚拟头指针+快慢双指针
// 巧妙！
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode faster = dummy;
        int counter = 0;
        while (counter <= n) {
            faster = faster.next;
            counter++;
        }

        ListNode slower = dummy;
        while (faster != null) {
            slower = slower.next;
            faster = faster.next;
        }
        slower.next = slower.next.next;
        return dummy.next;
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
