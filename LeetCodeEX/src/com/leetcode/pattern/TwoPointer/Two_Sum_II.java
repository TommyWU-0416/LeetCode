package com.leetcode.pattern.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 167.https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��8�� �W��11:26:57
 * @since JDK8.0
 * 
 *        �u�|���ߤ@�զX���A���|���O { 1, 2, 3, 4, 6 } ��X 5
 *        Example 1:
 *        Input: numbers = [2,7,11,15], target = 9
 *        Output: [1,2]
 *        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 =
 *        2.
 * 
 *        Example 2
 *        Input: numbers = [2,3,4], target = 6
 *        Output: [1,3]
 * 
 *        Example 3:
 *        Input: numbers = [-1,0], target = -1
 *        Output: [1,2]
 */
public class Two_Sum_II {
	private static int[] numbers = { 2, 4, 5, 8 };
	private static int target = 5;

	public static void main(String[] args) {
		Two_Sum_II test = new Two_Sum_II();
		System.out.print("bruteForce:");
		printnumbers(test.bruteForce(numbers, target));

		System.out.print("TwoPoint  :");
		printnumbers(test.TwoPoint(numbers, target));

		System.out.print("hashMap   :");
		printnumbers(test.hashMap(numbers, target));
	}

	/**
	 * �N target �C�@�Ӱű����s�bhashmap�A�M��p�G�J��@�Ӭ۴�G���s�bhash table
	 * �N�^�Ƿ�e��index+1�A�H�Φbtable��쪺��m
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] hashMap(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] answer = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				answer[0] = map.get(target - numbers[i]) + 1;
				answer[1] = i + 1;
				break;
			}
			map.put(numbers[i], i);
		}
		return answer;
	}

	/**
	 * �ϥΨ�� index ���V �}�C����ݡA��ۥ[ < target �᭱���N���e�A�̦������A�̦h�|�O n-2 �A�ҥ~����
	 * �ɶ�O(); �Ŷ�O(1)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] TwoPoint(int[] numbers, int target) {
		/* �ҥ~�B�z */
		if (numbers.length < 2) {
			return null;
		}
		if (numbers.length == 2) {
			return new int[] { 1, 2 };
		}

		int index1 = 0, index2 = numbers.length - 1;

		while (index1 <= index2) {
			if (target < numbers[index1] + numbers[index2]) {
				index2--;
			} else if (target > numbers[index1] + numbers[index2]) {
				index1++;
			} else if (target == numbers[index1] + numbers[index2]) {
				return new int[] { index1 + 1, index2 + 1 };
			}
		}
		return null;
	}

	/**
	 * �ϥμɤO�ѡA��C�@�ӳ�get�X�Ӭۥ[�A���O�N���U�@���ڶi
	 * �ݭn��� Time Limit Exceeded�A�]���o�˰����ɶ��|�O n^2�A�p�G�� 1000 �ӰѼƴN�n�� 1000^2
	 * �ɶ�O(n^2); �Ŷ�(
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] bruteForce(int[] numbers, int target) {
		/* �ҥ~�B�z */
		if (numbers.length < 2) {
			return null;
		}
		if (numbers.length == 2) {
			return new int[] { 1, 2 };
		}

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (target == numbers[i] + numbers[j]) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return null;
	}

	/**
	 * �C�L array �X��
	 * 
	 * @param arr
	 */
	public static void printnumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("arr[" + i + "]=" + numbers[i] + " ");
		}
		System.out.println();
	}
}
