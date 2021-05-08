package com.leetcode.pattern.TwoPointer;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��8�� �U��2:24:33
 * @since JDK8.0
 * 
 * 
 *        Input: nums = [-4,-1,0,3,10]
 *        Output: [0,1,9,16,100]
 *        Explanation: After squaring, the array becomes [16,1,0,9,100].
 *        After sorting, it becomes [0,1,9,16,100].
 */
public class Squares_of_a_Sorted_Array {
	private static int[] nums = { -4, -1, 1, 4, 10 };

	public static void main(String[] args) {
		Squares_of_a_Sorted_Array test = new Squares_of_a_Sorted_Array();
		printArray(test.twoPoint_1(nums));
		printArray(test.twoPoint_2(nums));

		/* test.exchange(nums); ���i�ϥ� */

	}

	/**
	 * �p�G�ϥΤ�j�p�A�J��N�洫�A�o�˷|���@�Ӱ��D[-5,-3,-2,-1]
	 * ��ڤ�Ĥ@���ܦ� -> [-1,-3,-2,-5]
	 * �ĤG���ܦ�[-1,-3,-2,-5]
	 * �ĤT���ܦ�[-1,-3,-2,-5]
	 * �洫����̵L�k���D�洫��P��L�����
	 * 
	 * @param nums
	 * @return
	 */
	public int[] exchange(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			System.out.println(nums[left]);
			System.out.println(nums[right]);
			if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
				int tmp = nums[right];
				nums[right] = (int) Math.pow(nums[left], 2);
				nums[left] = tmp;

				for (int i : nums) {
					System.out.print(i + " ");
				}

				right--;
			} else {
				nums[right] = (int) Math.pow(nums[right], 2);
				right--;
			}
		}
		return nums;
	}

	/**
	 * �u�� twoPoint_1 �ϥ� Math.abs�覡�����
	 * 
	 * @param nums
	 * @return
	 *         Runtime: 1 ms, faster than 100.00% of Java online submissions for
	 *         Squares of a Sorted Array.
	 *         Memory Usage: 40.9 MB, less than 42.13% of Java online submissions
	 *         for Squares of a Sorted Array.
	 */
	public int[] twoPoint_2(int[] nums) {
		int[] answer = new int[nums.length];
		int left = 0, right = nums.length - 1, point = nums.length - 1;
		while (left <= right) {
			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				answer[point--] = nums[left] * nums[left];
				left++;
			} else {
				answer[point--] = nums[right] * nums[right];
				right--;
			}
		}
		return answer;
	}

	/**
	 * �ϥ� Two Point ��̥�������j�p�A�j����k��
	 * 
	 * @param nums
	 * @return
	 * 
	 *         Runtime: 2 ms, faster than 51.75% of Java online submissions for
	 *         Squares of a Sorted Array.
	 *         Memory Usage: 40.6 MB, less than 79.74% of Java online submissions
	 *         for Squares of a Sorted Array.
	 */
	public int[] twoPoint_1(int[] nums) {
		int[] answer = new int[nums.length];
		int left = 0, right = nums.length - 1, point = nums.length - 1;
		while (left <= right) {
			int right_num = (int) Math.pow(nums[right], 2);
			int left_num = (int) Math.pow(nums[left], 2);
			if (left_num > right_num) {
				answer[point--] = left_num;
				left++;
			} else {
				answer[point--] = right_num;
				right--;
			}
		}
		return answer;
	}

	/**
	 * print Array
	 * 
	 * @param nums
	 */
	public static void printArray(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
