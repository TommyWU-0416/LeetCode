package com.leetcode.pattern.SlideWindow;

import java.util.HashMap;

/**
 * 159.https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * @author AaronWU
 * @version 創建時間：2021年5月22日 下午6:59:22
 * @since JDK8.0
 * 
 *        Given a string s , find the length of the longest substring t that
 *        contains at most 2 distinct characters.
 * 
 *        Example 1:
 * 
 *        Input: "eceba"
 *        Output: 3
 *        Explanation: tis "ece" which its length is 3.
 *        Example 2:
 * 
 *        Input: "ccaabbb"
 *        Output: 5
 *        Explanation: tis "aabbb" which its length is 5.
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters {
	private static String s1 = "ecebeeeeeeeea";

	public static void main(String[] args) {
		Longest_Substring_with_At_Most_Two_Distinct_Characters test = new Longest_Substring_with_At_Most_Two_Distinct_Characters();
		int result = test.lengthOfLongestSubstringTwoDistinct(s1);
		System.out.println("result:" + result);
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int window_start = 0, maxLength = 0;
		HashMap<Character, Integer> map = new HashMap();
		for (int window_end = 0; window_end < s.length(); window_end++) {
			if(map.containsKey(s.charAt(window_end))) {
				int value = map.get(s.charAt(window_end));
				map.put(s.charAt(window_end), ++value);
			}else {
				map.put(s.charAt(window_end), 1);
			}
			while (map.size() > 2) {
				int value = map.get(s.charAt(window_start));
				map.put(s.charAt(window_start), --value);
				if(map.get(s.charAt(window_start)) == 0) {
					map.remove(s.charAt(window_start));
				}
				window_start++;
			}
			maxLength = Math.max(maxLength, window_end - window_start + 1);
		}

		return maxLength;
	}
}
