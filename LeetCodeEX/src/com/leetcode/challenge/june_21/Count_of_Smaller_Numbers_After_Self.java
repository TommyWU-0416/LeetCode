package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AaronWU
 * @version 創建時間：2021年6月26日 下午9:16:58
 * @since JDK8.0
 */
public class Count_of_Smaller_Numbers_After_Self {
	private static int[] nums = { 5, 4, 3, 6, 2, 1 };/* 4 3 2 2 1 0 */

	public static void main(String[] args) {
		Count_of_Smaller_Numbers_After_Self test = new Count_of_Smaller_Numbers_After_Self();
		List<Integer> res = test.countSmaller(nums);
		printArray(res);

	}

	private static void printArray(List<Integer> res) {
		System.out.print("res:");
		for (int num : res) {
			System.out.print(num + " ");
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		int offset = 10000; // offset negative to non-negative
		int size = 2 * 10000 + 2; // total possible values in nums plus one dummy
		int[] tree = new int[size];
		List<Integer> result = new ArrayList<Integer>();

		for (int i = nums.length - 1; i >= 0; i--) {
			int smaller_count = query(nums[i] + offset, tree);
			result.add(smaller_count);
			update(nums[i] + offset, 1, tree, size);
		}
		Collections.reverse(result);
		return result;
	}

	public int lsb(int value) {
		return value & (-value);
	}

	// implement Binary Index Tree
	private void update(int index, int value, int[] tree, int size) {
		index++; // index in BIT is 1 more than the original index
		while (index < size) {
			tree[index] += value;
			index += lsb(index);
		}
	}

	private int query(int index, int[] tree) {
		// return sum of [0, index)
		int result = 0;
		while (index > 0) {
			result += tree[index];
			index -= lsb(index);
		}
		return result;
	}

	/**
	 * 二分法
	 * 
	 * Runtime : 723 ms, faster than 12.89
	 * Memory Usage :57.5 MB, less than 59.38%
	 * 
	 * @param nums
	 * @return
	 */
//	public List<Integer> countSmaller(int[] nums) {
//		List<Integer> t = new ArrayList<Integer>();
//		List<Integer> res = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));
//
//		for (int i = nums.length - 1; i >= 0; i--) {
//			int left = 0, right = t.size();
//			while (left < right) {
//				int mid = left + (right - left) / 2;
////				System.out.println("t.get(mid):" + t.get(mid) + ", nums[i]:" + nums[i]);
//				if (t.get(mid) >= nums[i])
//					right = mid;
//				else
//					left = mid + 1;
//			}
//			res.set(i, right);
//			if (t.size() <= right) {
//				t.add(nums[i]);
//			} else {
//				t.add(right, nums[i]);
//			}
//		}
//
//		return res;
//	}
	/**
	 * brute force fail
	 * 
	 * Runtime :
	 * Memory Usage :
	 * 
	 * @param nums
	 * @return
	 */
	/*
	 * public List<Integer> countSmaller(int[] nums) {
	 * List<Integer> list = new ArrayList<Integer>();
	 * int pre = nums[0];
	 * int count = 0;
	 * for (int i = 0; i < nums.length - 1; i++) {
	 * if(i != 0 && pre == nums[i]) {
	 * list.add(count);
	 * }
	 * count = 0;
	 * pre = nums[i];
	 * for (int j = i + 1; j < nums.length; j++) {
	 * if(nums[i] > nums[j]) count++;
	 * }
	 * list.add(count);
	 * }
	 * list.add(0);
	 * 
	 * return list;
	 * }
	 */
}
