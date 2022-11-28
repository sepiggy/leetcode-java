package cn.sepiggy.leetcode.linkedlist.p83;


class Solution {

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode slow = dummy, fast = head;

		while (fast != null) {
			if (fast.val != slow.val) {
				slow.next = new ListNode(fast.val);
				slow = slow.next;
			}
			fast = fast.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// final ListNode listNode = ListNode.fromArray(new int[]{1, 1, 2, 3, 3});
		final ListNode listNode = ListNode.fromArray(new int[]{1, 1, 2});
		final ListNode resultListNode = deleteDuplicates(listNode);
		System.out.println(resultListNode);
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