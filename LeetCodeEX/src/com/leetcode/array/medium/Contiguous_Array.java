package com.leetcode.array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~4��30�� �U��4:58:58
 * @since JDK8.0
 * 
 *        ��X�̪����l�}�C�A�䤤0�P1���Ӽƭn�ۦP
 *        Input: nums = [0,1]
 *        Output: 2
 *        Input: nums = [0,1,0]
 *        Output: 2
 *        Input: nums = [0,0,1,0,0,0,1,1]
 *        Output: 6
 *        Input: nums = [0,1,1,0,1,1,1,0]
 *        Output: 4
 */
public class Contiguous_Array {
	/*
	 * ��Ӯt���I�b���x�s���ɭԡAhashmap�ݭn��Jkey value���Oarray�u�ݭn�мg��*/
	public static void main(String[] args) {
		int[] nums = {0,1,1,0,1,1,1};
		System.out.println(findMaxLength(nums));
		System.out.println(findMaxLength1(nums));
		
	}

	public static int findMaxLength(int[] nums) {
		int sum = 0;
		int length_subArray = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);/* sum=0, index=-1 */
        
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i] == 0 ? -1 : 1;
			
			if(map.containsKey(sum)) {
                length_subArray = Math.max(length_subArray, i - map.get(sum));
			}else {
				map.put(sum, i);
			}
		}
		return length_subArray;
	}

	
	public static int findMaxLength1(int[] nums) {
		int[] arr = new int[2 * nums.length + 1];
		Arrays.fill(arr, -2);
		arr[nums.length] = -1;
		int length_subArray = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + (nums[i] == 0 ? -1 : 1);
			if (arr[count + nums.length] >= -1) {/* �}�C�̭��|�� index����סA-1 �O�]��index�q0�}�l�� */
				length_subArray = Math.max(length_subArray,
						i - arr[count + nums.length]);
			} else {
				arr[count + nums.length] = i;
			}

		}
		return length_subArray;
	}
}/* {0,0,1,0}; */
