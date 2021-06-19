package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.https://leetcode.com/problems/generate-parentheses/submissions/
 * 參考：https://www.cnblogs.com/grandyang/p/4444160.html
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月16日 下午10:10:21
 * @since JDK8.0
 */
public class Generate_Parentheses {
//	private static int n = 1;
//	private static int n = 2;
	private static int n = 3;
//	private static int n = 4;
//	private static int n = 5;
//	private static int n = 6;
//	private static int n = 7;
//	private static int n = 8;

	public static void main(String[] args) {
		Generate_Parentheses test = new Generate_Parentheses();
		List<String> ans = test.generateParenthesis(n);
		printArray(ans);
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		sol(res, n, n, "");
		return res;
	}

	private void sol(List<String> res, int left, int right, String tmp) {
		if (left < 0 || right < 0 || left > right)
			return; /* 當0要進來扣1的時候就要return 代表左邊已經做完，要做右邊了 */
		if (left == 0 && right == 0) {
			res.add(tmp);
			return;
		}

		sol(res, left - 1, right, tmp + "(");
		sol(res, left, right - 1, tmp + ")");
	}

	private static void printArray(List<String> list) {
		System.out.println("list: ");
		for (String s : list) {
			System.out.print(s + ", ");
		}
	}
}





