package cn.sepiggy.leetcode.linkedlist.p21;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
class Solution1 {

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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode dummy = new ListNode(-1), p = dummy;
		ListNode p1 = list1, p2 = list2;

		// p1和p2两个指针都没到头
		while (p1 != null && p2 != null) {

			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return dummy.next;
	}

}