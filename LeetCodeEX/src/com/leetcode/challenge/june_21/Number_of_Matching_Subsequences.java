package com.leetcode.challenge.june_21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月22日 下午9:56:15
 * @since JDK8.0
 */
public class Number_of_Matching_Subsequences {
	private static String s = "abcde";
	private static int[] nums = { 0, 1, 0, 0, 1, 1 };
	private static String[] words = { "a", "bb", "bb", "acd", "ace" };

	public static void main(String[] args) {
		Number_of_Matching_Subsequences test = new Number_of_Matching_Subsequences();

		System.out.println(test.numMatchingSubseq(s, words));

	}

	public int numMatchingSubseq(String s, String[] words) {
		int res = 0;
		Map<String, Boolean> map = new HashMap<String, Boolean>(); /* 負責記錄查詢過的字串是否有通過，提供下次查詢用 */
		for (String word : words) {
			if (map.containsKey(word)) { /* 如果有搜尋過 */
				if (map.get(word)) /* 如果搜尋結果為成功，res++ */
					res++;
				continue;
			}

			int i = 0, j = 0, k = word.length();
			while (i < s.length() && j < word.length()) {
				if (word.charAt(j) == s.charAt(i))
					j++; /* 如果找到 word 找到字，就找下一個 */
				i++;

			}
			if (j == k) { /* 如果查詢的次數跟字串長度一樣，代表有查詢到 */
				res++;
				map.put(word, true); /* 紀錄成功或失敗 */
			} else {
				map.put(word, false); /* 紀錄成功或失敗 */
			}
		}

		return res;
	}
}
