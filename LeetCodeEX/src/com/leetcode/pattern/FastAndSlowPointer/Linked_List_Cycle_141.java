package com.leetcode.pattern.FastAndSlowPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.https://leetcode.com/problems/linked-list-cycle/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��6�� �W��10:53:11
 * @since JDK8.0
 *        �o�D�|�� head �o�̭��w�g���n�� circle ���ǦC�A�ҥH��next�@���U�h�N�|�L��loop
 *        Input: head = [3,2,0,-4], pos = 1
 *        Output: true
 * 
 *        Input: head = [1], pos = -1
 *        Output: false
 * 
 *        Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class Linked_List_Cycle_141 {
	private static ListNode head1 = new ListNode(1);
	private static ListNode head2 = new ListNode(2, head1);
	private static ListNode head = new ListNode(1, head2);

	public static void main(String[] args) {
		Linked_List_Cycle_141 test = new Linked_List_Cycle_141();
		System.out.println("hasCycle_Brute:" + test.hasCycle_Brute(head));
		System.out.println("hasCycle_FastAndSlowPointer:" + test.hasCycle_FastAndSlowPointer(head));
	}

	/**
	 * Runtime: 0 ms
	 * Memory Usage: 42.8 MB
	 * time:O(n) space:O(1)
	 * �@�˥� Fast and Slow
	 * ��p�G���Ѧ�circle�A�N�|�o�{slow��fast�@�w�|���۹J���@�ѡC
	 * ��p�G���ѵLcircle�Afast���쩳�N�|null�A����N���D�S��circle�C
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle_FastAndSlowPointer(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	/**
	 * Runtime: 8 ms
	 * Memory Usage: 44.6 MB
	 * time:O(n) space:O(n)�Ŷ��n�h�sn�Ӭ����A�ҥH��n
	 * 
	 * Brute Force�����C�@�Ө��L���ȡA��쨫�L���N�O return true
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle_Brute(ListNode head) {
//		List<Integer> list = new LinkedList<Integer>();
//		�쥻�Q���� ��쪺node��val�s�_�ӡA�Ǧ����A���|�o�{�@�Ӱ��D�N�O�o�˪�node�N���i�H����
		Set<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head))
				return true;

			set.add(head);
			// System.out.println(head.val);
			head = head.next;
			// System.out.println(head.val);
		}
		return false;

	}
}
