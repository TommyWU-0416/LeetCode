package com.leetcode.challenge.june_21;

import java.util.Arrays;

/**
 * 473.https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��15�� �U��8:40:24
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
	 * �ϥ�DFS�A���Ƨ�
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
//		int perimeter = 0; /* �P�� */
//		for (int i = 0; i < matchsticks.length; i++) {
//			perimeter += matchsticks[i];
//		}
//		if (perimeter % 4 != 0)
//			return false; /* �D��� */
//
//		/* �p��C�@�ӥ[�_�ӬO�_����target�����ܴN�U�@�B */
//		int[] sums = new int[4];
//		return judgeSide(matchsticks, sums, 0, perimeter / 4);
//	}
//
//	private boolean judgeSide(int[] nums, int[] sums, int pos, int target) {
//		if (pos >= nums.length) { /* ��T����==target�A�N��ѤU���@�w�O�ĥ|���� */
//			return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
//		} /* 5, 5, 4, 3, 3, 2, 1, 1 */
//		for (int i = 0; i < 4; i++) {
//			if (sums[i] + nums[pos] > target)
//				continue;
//			sums[i] += nums[pos];
//			if (judgeSide(nums, sums, pos + 1, target))
//				return true;
//			sums[i] -= nums[pos];/* �Y�Ǳ��Ҥ��@�w���ۥ[�N�i�H���諸��A���i��O�Y���t */
//		}
//		return false;
//	}

	/**
	 * �ϥ�DFS�A�~�[�ƧǡA�B�q�᭱�˦^�Ӱ��A�̤j���Ʀr���Q��inums�A�o�ˤ���N�|���C�զX�����~
	 * �Ҧp�Gtarget�O8�A�p�G�ƧǬO[3, 3, 6...]�H��[6, 3, 3]�A�o�˲Ĥ@�մN�n�h��^�h�A�]���o��8���@�w��3 + 3 +
	 * X�զ��A�L�i��O 3 + 5 �զ�
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

		int perimeter = 0; /* �P�� */
		for (int i = 0; i < matchsticks.length; i++) {
			perimeter += matchsticks[i];
		}
		if (perimeter % 4 != 0)
			return false; /* �D��� */

		/* �p��C�@�ӥ[�_�ӬO�_����target�����ܴN�U�@�B */
		int[] sums = new int[4];
		Arrays.sort(matchsticks);
		return judgeSide(matchsticks, sums, matchsticks.length - 1, perimeter / 4);
	}

	private boolean judgeSide(int[] nums, int[] sums, int pos, int target) {
		if (pos == -1 && sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target) {
			return true;/* ��T����==target�A�N��ѤU���@�w�O�ĥ|���� */
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[pos] > target)
				continue;
			sums[i] += nums[pos];
			if (judgeSide(nums, sums, pos - 1, target))
				return true;
			sums[i] -= nums[pos];/* �Y�Ǳ��Ҥ��@�w���ۥ[�N�i�H���諸��A���i��O�Y���t */
		}
		return false;
	}

	/**
	 * �N�x�s���Ʀr�令��boolean�p�G�ιL�N��true
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
//			return false; /* �D��� */
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
