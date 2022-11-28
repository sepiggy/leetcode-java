package cn.sepiggy.leetcode.linkedlist.p876;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
class Solution {

	public ListNode middleNode(ListNode head) {

		// 快慢指针初始化指向 head
		ListNode slow = head, fast = head;
		// 快指针走到末尾时停止
		while (fast != null && fast.next != null) {
			// 慢指针走一步，快指针走两步
			slow = slow.next;
			fast = fast.next.next;
		}
		// 慢指针指向中点
		return slow;
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
}