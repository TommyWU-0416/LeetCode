package com.leetcode.challenge.june_21;

/**
 * 576.https://leetcode.com/problems/out-of-boundary-paths/submissions/
 * @author AaronWU
 * @version 創建時間：2021年6月24日 下午10:55:49
 * @since JDK8.0
 */
public class Out_of_Boundary_Paths {
//	private static int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
	private static int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;

	public static void main(String[] args) {
		Out_of_Boundary_Paths test = new Out_of_Boundary_Paths();
		int res = test.findPaths(m, n, maxMove, startRow, startColumn);
		System.out.println("res:" + res);
	}

	/**
	 * DP
	 * 
	 * Runtime :9 ms, faster than 43.58%
	 * Memory Usage : 37.7 MB, less than 95.16%
	 * 
	 * @param m
	 * @param n
	 * @param maxMove
	 * @param startRow
	 * @param startColumn
	 * @return
	 */
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		long[][][] dp = new long[maxMove + 1][m][n];
		for (int i = 1; i <= maxMove; i++) {/* 步數 */
			for (int j = 0; j < m; j++) { /* 高度 */
				for (int k = 0; k < n; k++) { /* 寬度 */
					/* i - 1 表示找上一筆紀錄 */
					/*
					 * m - 1 表示邊界-1 == 目前位置，再走一步就是邊界。
					 * 例如j=1, m=2，j在走一步就是邊界
					 */
					long v1 = (j == 0) ? 1 : dp[i - 1][j - 1][k];/* 上 */
					long v2 = (j == m - 1) ? 1 : dp[i - 1][j + 1][k];/* 下 */
					long v3 = (k == 0) ? 1 : dp[i - 1][j][k - 1];/* 左 */
					long v4 = (k == n - 1) ? 1 : dp[i - 1][j][k + 1];/* 右 */
					dp[i][j][k] = (v1 + v2 + v3 + v4) % 1000000007; /* 題目要求 */
					if (i == maxMove && j == startRow && k == startColumn)
						break;
				}
			}
		}
		/* dp[走的路徑數][起點_startRow][終點_startRow] */
		return (int) dp[maxMove][startRow][startColumn];
	}
}
