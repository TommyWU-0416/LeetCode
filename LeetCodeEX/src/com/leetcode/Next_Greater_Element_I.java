package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496.https://leetcode.com/problems/next-greater-element-i/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��23�� �U��5:14:27
 * @since JDK8.0
 *        You are given two integer arrays nums1 and nums2 both of unique
 *        elements, where nums1 is a subset of nums2.
 * 
 *        Find all the next greater numbers for nums1's elements in the
 *        corresponding places of nums2.
 * 
 *        The Next Greater Number of a number x in nums1 is the first greater
 *        number to its right in nums2. If it does not exist, return -1 for this
 *        number.
 *        Example 1:
 * 
 *        Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 *        Output: [-1,3,-1]
 *        Explanation:
 *        For number 4 in the first array, you cannot find the next greater
 *        number for it in the second array, so output -1.
 *        For number 1 in the first array, the next greater number for it in the
 *        second array is 3.
 *        For number 2 in the first array, there is no next greater number for
 *        it in the second array, so output -1.
 * 
 */
public class Next_Greater_Element_I {
	private static int[] nums1 = { 4, 5 }, nums2 = { 6, 2, 1, 5, 4 };
//	private static int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
//	private static int[] nums1 = { 1, 3, 5, 2, 4 }, nums2 = { 6, 5, 4, 3, 2, 1, 7 };

	public static void main(String[] args) {
		Next_Greater_Element_I test = new Next_Greater_Element_I();
		int[] num_result = test.nextGreaterElement1(nums1, nums2);
		printArray(num_result);
	}

	/**
	 * Runtime	4 ms
	 * Memory	38.9 MB
	 * time:O(n+m) space:O(1)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], i);
		}
		int[] result = new int[nums1.length];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<Integer>();
		for (int j = 0; j < nums2.length; j++) {
			while (!stack.isEmpty() && stack.peek() < nums2[j]) {
				int cur = stack.peek();
				stack.pop();

				/* �p�G���]�t�N�N��A�s�b��nums1 */
				if (map.containsKey(cur)) {
					result[map.get(cur)] = nums2[j];
				}
			}
			stack.push(nums2[j]);
		}

		return result;
	}

	/**
	 * brute force
	 * time:O(m*n) space:O(1)
	 * Runtime: 4 ms, faster than 52.32%
	 * Memory Usage: 39.1 MB, less than 47.34%
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 *         nums1 ��for�A��num2����쪺�ɭԡA�N�N���m�O�U��(target_index)
	 *         �U�@�Ӱj��N�|�i�� if (target_index > -1)�A�b�o�̭��P�_�O�_�����j�󪺼�
	 *         �Y�����ܴN���������A�Y�L�����~���A���̫�S�����ܴN�� -1
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] num_result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int count = 0, target_index = -1;
			while (count < nums2.length) {
				/* �P�_���L���A��줧����L�j���Ʀr */
				if (target_index > -1) {
					if (nums2[count] > nums1[i]) {
						num_result[i] = nums2[count];
						break;
					}
				}
				if (nums1[i] == nums2[count]) {
					target_index = count;
					if (target_index == nums2.length - 1) {
						num_result[i] = -1;
						break;
					}
				}

				count++;
			}
			/* ���̫�S���N��-1 */
			if (num_result[i] == 0) {
				num_result[i] = -1;
			}

		}

		return num_result;
	}

	public static void printArray(int[] num) {
		System.out.print("i: ");
		for (int i : num) {
			System.out.print(i + " ");
		}
	}
}
