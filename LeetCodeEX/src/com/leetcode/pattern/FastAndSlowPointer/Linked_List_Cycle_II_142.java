package com.leetcode.pattern.FastAndSlowPointer;

/**
 * 142.https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��6�� �W��11:51:53
 * @since JDK8.0
 */
public class Linked_List_Cycle_II_142 {

	public static void main(String[] args) {
		Linked_List_Cycle_II_142 test = new Linked_List_Cycle_II_142();
	}

	/**
	 * Runtime: 0 ms
	 * Memory Usage: 38.9 MB
	 * time:O(n) space:O(1)
	 * 
	 * ����@�˪��ɭԡA�N���i�J�`���A����fast�^�k��head�A���̦A��next�N�|���_�l���`���I
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
