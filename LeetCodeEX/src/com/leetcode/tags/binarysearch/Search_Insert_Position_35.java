package com.leetcode.tags.binarysearch;

/**
 * 35. https://leetcode.com/problems/search-insert-position/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~7��4�� �U��6:03:00
 * @since JDK8.0
 */
public class Search_Insert_Position_35 {
	private static int[] nums = {1,3,5,6}; 
	private static int target = 5;			/* Output : 2 */
//	private static int[] nums = [1,3,5,6];
//	private static int target = 2;			/* Output : 1 */
//	private static int[] nums = [1,3,5,6];
//	private static int target = 7;			/* Output : 4 */
	public static void main(String[] args) {
		Search_Insert_Position_35 test = new Search_Insert_Position_35();
		int res = test.searchInsert(nums, target);
		System.out.println("res:" + res);
	}

	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		
		
		
		return 0;
	}
}
