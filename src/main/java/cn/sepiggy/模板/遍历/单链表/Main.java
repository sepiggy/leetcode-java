package cn.sepiggy.模板.遍历.单链表;

/**
 * 单链表的两种遍历方式：
 * 1) 迭代
 * 2) 递归
 */
public class Main {

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

    /**
     * 迭代遍历单链表
     *
     * @param head
     */
    static void traverse1(ListNode head) {

        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }

    /**
     * 递归遍历单链表
     *
     * @param head
     */
    static void traverse2(ListNode head) {

        if (head == null) {
            return;
        }

        // 前序遍历
//        System.out.println(head.val);

        traverse2(head.next);

        // 后序遍历
        System.out.println(head.val);
    }

    public static void main(String[] args) {

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode p = dummyNode;

        for (int i = 1; i <= 10; i++) {

            p.next = new ListNode(i);
            p = p.next;
        }

        ListNode head = dummyNode.next;

//        traverse1(head);

        traverse2(head);
    }
}
