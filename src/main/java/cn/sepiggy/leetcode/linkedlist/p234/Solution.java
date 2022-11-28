package cn.sepiggy.leetcode.linkedlist.p234;

class ListNode {

    int val;
    ListNode next;
    StringBuilder sb;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String fetchString() {
        doFetchString(this);
        return sb.toString();
    }

    private void doFetchString(ListNode head) {
        if (head == null) {
            return;
        }
        sb.append(head.val);
        sb.append("->");
        doFetchString(head.next);
    }
}

//class Solution {
//
//    public boolean isPalindrome(ListNode head) {
//
//        Deque<Integer> stack = new ArrayDeque<>();
//        ListNode visitor = head;
//
//        while (visitor != null) {
//            stack.push(visitor.val);
//            visitor = visitor.next;
//        }
//
//        ListNode reverse = reverse(head);
//        visitor = reverse;
//        while (visitor != null) {
//            Integer pop = stack.pop();
//            if (pop != visitor.val) {
//                return false;
//            }
//            visitor = visitor.next;
//        }
//
//        return true;
//    }
//
//    // eg. 1->2->3->4->5->null
//    ListNode reverse(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // 1->2<-3<-4<-5
//        ListNode newHead = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return newHead;
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        new Solution().isPalindrome(head);
//    }
//}

class Solution {

    ListNode visitor;

    public boolean isPalindrome(ListNode head) {
        visitor = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && (visitor.val == head.val);
        visitor = visitor.next;
        return res;
    }
}