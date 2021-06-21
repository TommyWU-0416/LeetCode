package com.leetcode.challenge.june_21;

import java.util.Arrays;

/**
 * 473.https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月15日 下午8:40:24
 * @since JDK8.0
 */
public class Matchsticks_to_Square {
//	private static int[] matchsticks = { 1, 1, 2, 2, 2 };						/* return true */
//	private static int[] matchsticks = { 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3 };	/* return true */
//	private static int[] matchsticks = { 2, 3, 1, 1, 1, 1, 2, 1 };				/* return true */
//	private static int[] matchsticks = { 2, 1, 3, 1, 1, 1, 2, 1 };				/* return true */
//	private static int[] matchsticks = { 5, 5, 4, 3, 3, 2, 1, 1 }; 				/* return true */
	private static int[] matchsticks = { 4, 4, 1, 1, 3, 3 }; /* return true */

//	private static int[] matchsticks = { 3, 3, 3, 3, 4 };						/* return false*/

	public static void main(String[] args) {
		Matchsticks_to_Square test = new Matchsticks_to_Square();
		System.out.println("ANS:" + test.makesquare(matchsticks));
	}

	/**
	 * 使用DFS，不排序
	 * Runtime: 1045 ms
	 * Memory Usage: 36.1 MB
	 * 
	 * @param matchsticks
	 * @return
	 */
//	public boolean makesquare(int[] matchsticks) {
//		if (matchsticks == null || matchsticks.length < 4)
//			return false;
//
//		int perimeter = 0; /* 周長 */
//		for (int i = 0; i < matchsticks.length; i++) {
//			perimeter += matchsticks[i];
//		}
//		if (perimeter % 4 != 0)
//			return false; /* 非整數 */
//
//		/* 計算每一個加起來是否有到target有的話就下一步 */
//		int[] sums = new int[4];
//		return judgeSide(matchsticks, sums, 0, perimeter / 4);
//	}
//
//	private boolean judgeSide(int[] nums, int[] sums, int pos, int target) {
//		if (pos >= nums.length) { /* 當三個邊==target，代表剩下的一定是第四個邊 */
//			return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
//		} /* 5, 5, 4, 3, 3, 2, 1, 1 */
//		for (int i = 0; i < 4; i++) {
//			if (sums[i] + nums[pos] > target)
//				continue;
//			sums[i] += nums[pos];
//			if (judgeSide(nums, sums, pos + 1, target))
//				return true;
//			sums[i] -= nums[pos];/* 某些情境不一定順著加就可以找到對的邊，有可能是頭尾配 */
//		}
//		return false;
//	}

	/**
	 * 使用DFS，外加排序，且從後面倒回來做，最大的數字先被放進nums，這樣之後就會降低組合的錯誤
	 * 例如：target是8，如果排序是[3, 3, 6...]以及[6, 3, 3]，這樣第一組就要多減回去，因為這個8不一定有3 + 3 +
	 * X組成，他可能是 3 + 5 組成
	 * 
	 * Runtime : 29 ms, faster than 59.94%
	 * Memory Usage : 38.8 MB, less than 11.61%
	 * 
	 * @param matchsticks
	 * @return
	 */
	public boolean makesquare(int[] matchsticks) {
		if (matchsticks == null || matchsticks.length < 4)
			return false;

		int perimeter = 0; /* 周長 */
		for (int i = 0; i < matchsticks.length; i++) {
			perimeter += matchsticks[i];
		}
		if (perimeter % 4 != 0)
			return false; /* 非整數 */

		/* 計算每一個加起來是否有到target有的話就下一步 */
		int[] sums = new int[4];
		Arrays.sort(matchsticks);
		return judgeSide(matchsticks, sums, matchsticks.length - 1, perimeter / 4);
	}

	private boolean judgeSide(int[] nums, int[] sums, int pos, int target) {
		if (pos == -1 && sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target) {
			return true;/* 當三個邊==target，代表剩下的一定是第四個邊 */
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[pos] > target)
				continue;
			sums[i] += nums[pos];
			if (judgeSide(nums, sums, pos - 1, target))
				return true;
			sums[i] -= nums[pos];/* 某些情境不一定順著加就可以找到對的邊，有可能是頭尾配 */
		}
		return false;
	}

	/**
	 * 將儲存的數字改成放boolean如果用過就放true
	 * 
	 * Runtime :3 ms, faster than 90.67%
	 * Memory Usage : 38.4 MB, less than 15.36%
	 * 
	 * @param nums
	 * @return
	 */
//	public boolean makesquare(int[] matchsticks) {
//		if (matchsticks == null || matchsticks.length < 4)
//			return false;
//
//		int perimeter = 0;
//		for (int i = 0; i < matchsticks.length; i++) {
//			perimeter += matchsticks[i];
//		}
//		if (perimeter % 4 != 0)
//			return false; /* 非整數 */
//		boolean[] used = new boolean[matchsticks.length];
//		Arrays.sort(matchsticks);
//
//		return dfs(matchsticks, 0, 0, used, perimeter / 4);
//	}
//
//	private boolean dfs(int[] nums, int currSum, int count, boolean[] used, int target) {
//		if (currSum == target) {
//			count++; // number of the length
//			if (count == 3)
//				return true;
//			currSum = 0;
//		}
//		if (currSum > target)
//			return false;
//
//		// backTracking method.
//		for (int i = nums.length - 1; i >= 0; i--) {
//			if (used[i])
//				continue;
//			if (currSum + nums[i] > target)
//				break; // very important, since currSum <= edge, if currSum > edge, we need return
//						// false
//			used[i] = true;
//			if (dfs(nums, currSum + nums[i], count, used, target))
//				return true;
//			used[i] = false;
//		}
//		return false;
//	}
}
