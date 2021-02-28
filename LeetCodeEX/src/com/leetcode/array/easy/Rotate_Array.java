package com.leetcode.array.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/rotate-array/submissions/
 * @author AaronWU
 * @version �Ыخɶ��G2021�~2��27�� �U��11:01:48
 * @since JDK8.0
 * 
 *        Input: nums = [1,2,3,4,5,6,7], k = 3
 *        Output: [5,6,7,1,2,3,4]
 *        Explanation:
 *        rotate 1 steps to the right: [7,1,2,3,4,5,6]
 *        rotate 2 steps to the right: [6,7,1,2,3,4,5]
 *        rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *        rotate 4 steps to the right: [4,5,6,7,1,2,3]
 * 
 *        Input: nums = [-1], k = 2
 *        Output: [-1]
 * 
 *        ���
 *        nums.length > k
 *        nums.length = n*k ���ΰ�
 *        nums.length < k ��l�� �t k = �l�� ex: 3 < 7, k = 1
 */
public class Rotate_Array {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		rotate(nums, k);
	}
	/*
	 * 67 12345 k = 2
	 * index 0 1 2 3 4 5 6
	 * 5 6 0 1 2 3 4
	 * 
	 * 567 1234 k = 3
	 * index 0 1 2 3 4 5 6 ; 11 22 33 44 55 66 77
	 * 4 5 6 0 1 2 3 ; 55 66 77 11 22 33 44
	 * 
	 * 234567 1 k = 6
	 * index 0 1 2 3 4 5 6; 11 22 33 44 55 66 77
	 *       1 2 3 4 5 6 0; 22 33 44 55 66 77 11
	 * �۴����ȳ��O4
	 */
	public static void rotate(int[] nums, int k) {
		int count = 0;
		if (k / nums.length != 0 & k % nums.length == 0 | nums.length == 1) {
			/* ���׻P k �e���� | ���� = 1 */
		} else {
			if (nums.length < k) {
				k = k % nums.length;
			}
			
/* method 2 */
			int[] nums1 = new int[k];
			for(int i = 0; i < k; i++) {
				nums1[i] = nums[nums.length - k + i];
				System.out.print(nums1[i] + " ");
			}
			System.out.println();
			
			for(int i = nums.length-1 ; i >= k ; i-- ) {
				nums[i] = nums[i-k];
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
			for(int i = 0; i < k; i++) {
				nums[i] = nums1[i];
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
			for(int i : nums) {
				System.out.print(i + " ");
			}
/* method 1 */
//			int[] nums1 = new int[nums.length];
//			for (int i = 0; i < nums.length; i++) {
//				count = nums.length - k + i;
//
//				if (count >= nums.length) {
//					count = i - k;
//				}
//				nums1[i] = nums[count];
//			}
//			for (int i = 0; i < nums.length; i++) {
//				nums[i] = nums1[i];
//			}
		}
	}
}
