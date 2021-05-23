package com.leetcode.pattern.SlideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3.https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author AaronWU
 * @version 創建時間：2021年5月22日 下午11:41:18
 * @since JDK8.0
 * 
 *        Example 1:
 * 
 *        Input: s = "abcabcbb"
 *        Output: 3
 *        Explanation: The answer is "abc", with the length of 3.
 *        Example 2:
 * 
 *        Input: s = "bbbbb"
 *        Output: 1
 *        Explanation: The answer is "b", with the length of 1.
 *        Example 3:
 * 
 *        Input: s = "pwwkew"
 *        Output: 3
 *        Explanation: The answer is "wke", with the length of 3.
 *        Notice that the answer must be a substring, "pwke" is a subsequence
 *        and not a substring.
 *        Example 4:
 * 
 *        Input: s = ""
 *        Output: 0
 */
public class Longest_Substring_Without_Repeating_Characters {
//	private static String s = "abcabcbb";

//	private static String s = "bbbbb";
	private static String s = "abba";

//	private static String s = "";
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters test = new Longest_Substring_Without_Repeating_Characters();
		int result = test.lengthOfLongestSubstring(s);
		System.out.println("result:" + result);
	}

	/**
	 * Runtime: 6 ms, Memory Usage: 39 MB
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();
		int maxLength = 0, window_start = 0, window_end = 0;
		int count = 0;
		/* abcabcbb */
		while (window_end < s.length()) {
			System.out.println("count:" + count);
			count++;
			if (set.contains(s.charAt(window_end))) {
				set.remove(s.charAt(window_start));
				window_start++;
			} else {
				set.add(s.charAt(window_end));
				maxLength = Math.max(maxLength, window_end - window_start + 1);
				window_end++;
			}

		}

		return maxLength;
	}
}
