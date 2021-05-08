package com.leetcode.pattern.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AaronWU
 * @version 創建時間：2021年5月8日 上午11:26:57
 * @since JDK8.0
 * 
 *        https://leetcode.com/problems/two-sum-ii-input-numbers-is-sorted/
 * 
 *        Example 1:
 * 
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
	private static int[] numbers = { 1, 2, 3, 5, 6 };
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
	 * 將 target 每一個剪掉的存在hashmap，然後如果遇到一個相減結果有存在hash table
	 * 就回傳當前的index+1，以及在table找到的位置
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] hashMap(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				ret[0] = map.get(target - numbers[i]) + 1;
				ret[1] = i + 1;
				break;
			}
			map.put(numbers[i], i);
		}
		return ret;
	}

	/**
	 * 使用兩個 index 指向 陣列的兩端，當相加 < target 後面的就往前，依此類推，最多會是 n-2 ，例外不算
	 * 時間O(); 空間O(1)
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] TwoPoint(int[] numbers, int target) {
		/* 例外處理 */
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
	 * 使用暴力解，把每一個都get出來相加，不是就往下一個邁進
	 * 需要擔心 Time Limit Exceeded，因為這樣做的時間會是 n^2，如果有 1000 個參數就要做 1000^2
	 * 時間O(n^2); 空間(
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] bruteForce(int[] numbers, int target) {
		/* 例外處理 */
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
	 * 列印 array 出來
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
