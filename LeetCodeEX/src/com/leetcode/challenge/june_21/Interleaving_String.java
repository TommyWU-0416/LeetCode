package com.leetcode.challenge.june_21;

/**
 * 97.https://leetcode.com/problems/interleaving-string/
 * 
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月5日 上午10:49:53
 * @since JDK8.0
 * 
 *        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 *        Output: true
 * 
 *        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 *        Output: false
 */
public class Interleaving_String {
//	private static String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//	private static String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
//	private static String s1 = "a", s2 = "", s3 = "c";
//	private static String s1 = "", s2 = "", s3 = "";
	private static String s1 = "ab", s2 = "cd", s3 = "abcd";
//	private static String s1 = "aa", s2 = "ab", s3 = "aaba"; /* true */

	public static void main(String[] args) {
		Interleaving_String test = new Interleaving_String();
		boolean b = test.isInterleave(s1, s2, s3);
		System.out.println("boolean:" + b);
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
		
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		for(int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if(i==0 && j==0) {
					dp[i][j] = true; 	/* 當s1 與 s2 都為空值，代表s3也是空值 */
				}
				/* 	初始化邊緣，dp[i][j-1]判斷j的上一筆是否為true是否有連貫 
					s2.charAt(j-1)第j-1筆資料 
				 	s3.charAt(i+j-1) 這裡要分開看成 i+(j-1)因為i不變，都只有j會更動 */
				else if(i==0) {
					dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
				}
				/* 	初始化邊緣，dp[i][j-1]判斷j的上一筆是否為true是否有連貫 
				s2.charAt(j-1)第j-1筆資料 
			 	s3.charAt(i+j-1) 這裡要分開看成 i+(j-1)因為i不變，都只有j會更動 */
				else if(j==0) {				
					dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j);
				}
				else {
					dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) ||
							   dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j);
				}
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
}
