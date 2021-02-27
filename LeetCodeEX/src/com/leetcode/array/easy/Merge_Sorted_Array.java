package com.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author  AaronWU
 * @version �Ыخɶ��G2020�~1��21�� �U��5:48:08
 * @since   JDK8.0
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * nums1.length == m + n
 * nums2.length == n
 */
public class Merge_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,0,0,0};
		int[] arr2 = {2,5,6};
		int m = 3, n = 3;
		merge(arr1, m, arr2, n);
	}
	/**
	 * ���I�b�󻡡A�p��վ�w�g�T�w���ת� array �A�@�}�l�Q���� arraylist ���O�d�b���٭n�� arraylist �s�^ array �Ӯ�
	 * �s���Q�k�N�O�����N�᭱�h���վ㦨 arr2 �A�h���ƧǡC
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i = 0; i < n; i++) {
			nums1[i + m] = nums2[i];/* nums1[6] = nums2[0] */
		}
		Arrays.sort(nums1);
		for(int i : nums1) {
			System.out.print(i + " ");
		}
	}
}
