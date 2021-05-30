package com.leetcode.pattern.NextGreaterElement;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 503.https://leetcode.com/problems/next-greater-element-ii/
 * 
 * @author AaronWU
 * @version 創建時間：2021年5月23日 下午10:38:20
 * @since JDK8.0
 * 
 *        Example 1:
 * 
 *        Input: nums = [1,2,1]
 *        Output: [2,-1,2]
 *        Explanation: The first 1's next greater number is 2;
 *        The number 2 can't find next greater number.
 *        The second 1's next greater number needs to search circularly, which
 *        is also 2.
 *        Example 2:
 * 
 *        Input: nums = [1,2,3,4,3]
 *        Output: [2,3,4,-1,4]
 */
public class Next_Greater_Element_II {
	private static int[] nums = { };

	public static void main(String[] args) {
		Next_Greater_Element_II test = new Next_Greater_Element_II();
		int[] result = test.nextGreaterElements(nums);
		printArray(result);
	}

	public int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0)
			return new int[0];
		Deque<Integer> stack = new LinkedList<>();
		int[] res = new int[nums.length];
		for (int i = 2 * nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}

			res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}

	public static void printArray(int[] num) {
		System.out.print("i: ");
		for (int i : num) {
			System.out.print(i + " ");
		}
	}
}
