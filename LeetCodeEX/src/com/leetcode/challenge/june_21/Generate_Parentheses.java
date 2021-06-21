package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.https://leetcode.com/problems/generate-parentheses/submissions/
 * �ѦҡGhttps://www.cnblogs.com/grandyang/p/4444160.html
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��16�� �U��10:10:21
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
	/**
	 * 
	 * 
	 * Runtime :0 ms, faster than 100.00%
	 * Memory Usage : 39.1 MB, less than 50.01%
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) { /* ��n = 3, �Ÿ��|������ */
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
	
	
	/**
	 * DFS ���⥪�䪺�A�������L�X�ӡA�A�}�l��^�u����ӥ��A���A�A�Ӥ@�ӥ��A��
	 * 
	 * Runtime :1 ms, faster than 71.44%
	 * Memory Usage : 39.5 MB, less than 24.49%
	 * 
	 * @param n
	 * @return
	 */
//	public List<String> generateParenthesis(int n) {
//		List<String> res = new ArrayList<String>();
//		sol(res, n, n, "");
//		return res;
//	}
//
//	private void sol(List<String> res, int left, int right, String tmp) {
//		if (left < 0 || right < 0 || left > right)
//			return; /* ��0�n�i�Ӧ�1���ɭԴN�nreturn �N������w�g�����A�n���k��F */
//		if (left == 0 && right == 0) {
//			res.add(tmp);
//			return;
//		}
//
//		sol(res, left - 1, right, tmp + "(");
//		sol(res, left, right - 1, tmp + ")");
//	}
//
    /**
     * PrintArray
     * @param list
     */
	private static void printArray(List<String> list) {
		System.out.println("list: ");
		for (String s : list) {
			System.out.print(s + ", ");
		}
	}
}




