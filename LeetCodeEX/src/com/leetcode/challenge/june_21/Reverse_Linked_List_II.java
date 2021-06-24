package com.leetcode.challenge.june_21;

import com.leetcode.pattern.FastAndSlowPointer.ListNode;

/**
 *
 * @author AaronWU
 * @version 創建時間：2021年6月23日 下午11:06:23
 * @since JDK8.0
 */
public class Reverse_Linked_List_II {
	private static ListNode head5 = new ListNode(5);
	private static ListNode head4 = new ListNode(4, head5);
	private static ListNode head3 = new ListNode(3, head4);
	private static ListNode head2 = new ListNode(2, head3);
//	private static ListNode head  = new ListNode(1, head2);
	private static ListNode head = new ListNode(5);
	private static int left = 1;
	private static int right = 1;

	public static void main(String[] args) {
		Reverse_Linked_List_II test = new Reverse_Linked_List_II();
		ListNode res = test.reverseBetween(head, left, right);
	}

	/**
	 * 
	 * 
	 * Runtime :0 ms, faster than 100.00%
	 * Memory Usage : 36.6 MB, less than 57.89%
	 * 
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1), pre = dummy;
		dummy.next = head;
		for (int i = 0; i < left - 1; i++)
			pre = pre.next;
		ListNode cur = pre.next;

		for (int j = left; j < right; j++) {
			ListNode t = cur.next;
			cur.next = t.next;
			t.next = pre.next;
			pre.next = t;
		}
		return dummy.next;
	}
}
