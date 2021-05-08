package com.leetcode.pattern.TwoPointer;

/**
 * 713.https://leetcode.com/problems/subarray-product-less-than-k/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��8�� �U��7:13:04
 * @since JDK8.0
 * 
 *        Your are given an array of positive integers nums.
 * 
 *        Count and print the number of (contiguous) subarrays where the product
 *        of all the elements in the subarray is less than k.
 * 
 *        Example 1:
 *        Input: nums = [10, 5, 2, 6], k = 100
 *        Output: 8
 *        Explanation: The 8 subarrays that have product less than 100 are:
 *        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 *        Note that [10, 5, 2] is not included as the product of 100 is not
 *        strictly less than k.
 * 
 *        Input : [1, 2, 3], 0
 *        Output:
 */
public class Subarray_Product_Less_Than_K {
	private static int[] nums = { 10, 5, 2, 6 };
	private static int k = 100;

	public static void main(String[] args) {
		Subarray_Product_Less_Than_K test = new Subarray_Product_Less_Than_K();
		test.twoPoint(nums, k);
	}

	/**
	 * �ɶ�������O(n)�A�ɤO�Ѫ��ܭnO(n*n*n)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int twoPoint(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int count = 0;
		int product = 1, left = 0;

		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];

			while (product >= k) {
				product /= nums[left];
				left++;
			}

			count += right - left + 1;
			/* �h��1�O�������Aright-left�O��̤��� */
			System.out.println("count:" + count);
		}

		return count;
	}
}
