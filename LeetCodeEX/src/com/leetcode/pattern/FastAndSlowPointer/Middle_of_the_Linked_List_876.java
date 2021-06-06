package com.leetcode.pattern.FastAndSlowPointer;

/**
 * 876.https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��5�� �U��10:01:42
 * @since JDK8.0
 *        Input: [1,2,3,4,5]
 *        Output: Node 3 from this list (Serialization: [3,4,5])
 *        The returned node has value 3. (The judge's serialization of this node
 *        is [3,4,5]).
 *        Note that we returned a ListNode object ans, such that:
 *        ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and
 *        ans.next.next.next = NULL.
 * 
 * 
 */
public class Middle_of_the_Linked_List_876 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		ListNode listnode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		Middle_of_the_Linked_List_876 test = new Middle_of_the_Linked_List_876();
		ListNode res = test.middleNode(listnode);
		System.out.println(res);
	}

	/**
	 * Runtime: 0 ms
	 * Memory Usage: 38.5 MB
	 * time:O(n+m) space:O(1)
	 * 
	 * �o�D�� while �� ListNode head �O�_�ƭӡA����� fast �w�g��̫᪺�ɭԥL�� next �N�O null�A�N�N��L�w�g�쩳�F
	 * fast != null ==> ���ƪ��ɭԡAfast�����Ū��ɶ��A�N�O�쩳�F
	 * fast.next != null ==> ��_�ƪ��ɭԡAfast.next �|�O null �N���D�쩳�F
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			if (slow != null)
				System.out.println("slow:" + slow.val);
			fast = fast.next.next;
			if (fast != null)
				System.out.println("fast:" + fast.val);
		}
		return slow;
	}
}
