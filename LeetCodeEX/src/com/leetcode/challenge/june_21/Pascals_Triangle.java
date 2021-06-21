package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.https://leetcode.com/problems/pascals-triangle/
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3786/
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月21日 下午8:45:00
 * @since JDK8.0
 */
public class Pascals_Triangle {
//	private static int numRows = 1;
//	private static int numRows = 2;
//	private static int numRows = 3;
//	private static int numRows = 4;
//	private static int numRows = 5;
//	private static int numRows = 6;
	private static int numRows = 7;
//	private static int numRows = 8;

	public static void main(String[] args) {
		Pascals_Triangle test = new Pascals_Triangle();
		List<Integer> list = new ArrayList<Integer>();
		printArray(test.generate(numRows));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);

		for (int i = 0; i < numRows; i++) {/* numRows = 4, i = 0~3 */
			List<Integer> sublist = new ArrayList<Integer>(i + 1);
			sublist.add(1); /* the first */
			for (int j = 1; j < i; j++) {/* numsRow = 4, j = 1~2 */
				sublist.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
			}
			if (i != 0) {
				sublist.add(1);
			}
			list.add(sublist); /* the last */
		}
		return list;
	}

	private static void printArray(List<List<Integer>> res) {
		for (List<Integer> sublist : res) {
			System.out.print("[ ");
			for (Integer context : sublist) {
				System.out.print(context + " ");
			}
			System.out.println("]");
		}
	}
}
