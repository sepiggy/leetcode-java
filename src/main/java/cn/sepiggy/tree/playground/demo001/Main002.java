package cn.sepiggy.tree.playground.demo001;

/**
 * ???????
 */
public class Main002 {

    static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * ???????
     *
     * @param head
     */
    void traverse(ListNode head) {
        if (head == null) {
            return;
        }

        // ????
        traverse(head.next);
        // ????
    }

}
