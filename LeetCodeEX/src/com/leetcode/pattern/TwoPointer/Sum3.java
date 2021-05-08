package com.leetcode.pattern.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.https://leetcode.com/problems/3sum/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��8�� �U��4:00:57
 * @since JDK8.0
 * 
 *        Given an integer array nums, return all the triplets [nums[i],
 *        nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] +
 *        nums[j] + nums[k] == 0.
 *        Input : nums = [-1,0,1,2,-1,-4]
 *        Output: [[-1,-1,2],[-1,0,1]]
 * 
 *        Input : nums = [-2,0,0,2,2]
 *        Output: [[-2,0,2]]
 * 
 *        Input : nums = [-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0]
 *        Output:
 *        [[-5,1,4],[-3,-1,4],[-3,0,3],[-2,-1,3],[-2,1,1],[-1,0,1],[0,0,0]]
 * 
 *        Input : nums = [0,0,0]
 *        Output: [[0, 0, 0]]
 */
public class Sum3 {
	private static int[] nums = { -2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0 };

	public static void main(String[] args) {
		Sum3 test = new Sum3();
		printList(test.threeSum(nums));
	}

	/**
	 * ����䤤�@�誺x���X�ӡAy+z�n����x�o�˴N��Two Point�M ��Target�@�ˡA
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return list;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i
					- 1]) { /* skip same element */
				continue;
			}

			TwoPoint(nums, i + 1, -nums[i], list);
		}
		return list;
	}

	/**
	 * start�|�� i+1 �O�]�� �q 0~i ���O�L�k�t�X���Τw�g��X�Ӫ��A�ҥH���ΦA��@���A���קK����
	 * 
	 * @param numbers ��array
	 * @param start   two point�n�}�l�p�⪺�a��
	 * @param target  �M�䪺�ؼ�
	 * @param list    ��^��list
	 */
	public static void TwoPoint(int[] numbers, int start, int target,
			List<List<Integer>> list) {

		int index1 = start, index2 = numbers.length - 1;

		while (index1 < index2) {
			if (target < numbers[index1] + numbers[index2]) {
				index2--;
			} else if (target > numbers[index1] + numbers[index2]) {
				index1++;
			} else if (target == numbers[index1] + numbers[index2]) {
				List<Integer> list1 = new ArrayList<Integer>();
				list1.add(-target);
				list1.add(numbers[index1]);
				list1.add(numbers[index2]);
				list.add(list1);
				index1++;/* ����target���ɭԡA���䳣�ݭn�V����줣���ƪ�index */
				index2--;
				
				while (index1 < index2 && numbers[index1] == numbers[index1 - 1]) {
					index1++;
				}

				while (index1 < index2 && numbers[index2] == numbers[index2 + 1]) {
					index2--;
				}
			}
		}
	}

	public static void printList(List<List<Integer>> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print("[");
			for(int a : list.get(i)) {
				System.out.print(a + " ");
			}
			System.out.println("]");
		}
	}
}
