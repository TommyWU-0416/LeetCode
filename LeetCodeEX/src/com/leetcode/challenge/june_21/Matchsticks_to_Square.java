package com.leetcode.challenge.june_21;

/**
 * 473.https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��15�� �U��8:40:24
 * @since JDK8.0
 */
public class Matchsticks_to_Square {
//	private static int[] matchsticks = { 1, 1, 2, 2, 2 };
//	private static int[] matchsticks = { 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3 };
	private static int[] matchsticks = { 2, 3, 1, 1, 1, 1, 2, 1 };
//	private static int[] matchsticks = { 2, 1, 3, 1, 1, 1, 2, 1 };
//	private static int[] matchsticks = {3,3,3,3,4};

	public static void main(String[] args) {
		Matchsticks_to_Square test = new Matchsticks_to_Square();
		System.out.println("ANS:" + test.makesquare(matchsticks));
	}

	/**
	 * Runtime: 1045 ms
	 * Memory Usage: 36.1 MB
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
		return judgeSide(matchsticks, sums, 0, perimeter / 4);
	}

	private boolean judgeSide(int[] nums, int[] sums, int pos, int target) {
		if (pos >= nums.length) {
			return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[pos] > target)
				continue;
			sums[i] += nums[pos];
			if (judgeSide(nums, sums, pos + 1, target))
				return true;
			sums[i] -= nums[pos];
		}
		return false;
	}

}
