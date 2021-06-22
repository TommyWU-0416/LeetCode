package com.leetcode.challenge.june_21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��22�� �U��9:56:15
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
		Map<String, Boolean> map = new HashMap<String, Boolean>(); /* �t�d�O���d�߹L���r��O�_���q�L�A���ѤU���d�ߥ� */
		for (String word : words) {
			if (map.containsKey(word)) { /* �p�G���j�M�L */
				if (map.get(word)) /* �p�G�j�M���G�����\�Ares++ */
					res++;
				continue;
			}

			int i = 0, j = 0, k = word.length();
			while (i < s.length() && j < word.length()) {
				if (word.charAt(j) == s.charAt(i))
					j++; /* �p�G��� word ���r�A�N��U�@�� */
				i++;

			}
			if (j == k) { /* �p�G�d�ߪ����Ƹ�r����פ@�ˡA�N���d�ߨ� */
				res++;
				map.put(word, true); /* �������\�Υ��� */
			} else {
				map.put(word, false); /* �������\�Υ��� */
			}
		}

		return res;
	}
}
