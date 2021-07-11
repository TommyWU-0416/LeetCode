package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.List;

/**
 * 684.https://leetcode.com/problems/redundant-connection/
 * 
 * @author AaronWU
 * @version 創建時間：2021年6月25日 下午10:39:19
 * @since JDK8.0
 */
public class Redundant_Connection {
//	private static int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };					/*	2 3	*/
//	private static int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };/*	1 4	*/
	private static int[][] edges = { { 1, 4 }, { 3, 4 }, { 1, 3 }, { 1, 2 }, { 4, 5 } };/* 1 3 */

	public static void main(String[] args) {
		Redundant_Connection test = new Redundant_Connection();
		int[] res = test.findRedundantConnection(edges);
		printArray(res);
	}

	private static void printArray(int[] res) {
		System.out.print("res:");
		for (int x : res) {
			System.out.print(x + " ");
		}
	}

	public int[] findRedundantConnection(int[][] edges) {
		int[] list = new int[edges.length + 1];
		for (int[] edge : edges) {/* 將 edge裡面的數，去比對以前有沒有存過 */
			int x = find(list, edge[0]);
			int y = find(list, edge[1]);
			if (x == y)
				return edge;
			list[x] = y;
		}

		return null;
	}

	private int find(int[] list, int i) { /* 判斷是否有在之前存過，list[i]存位置，返回位置 */
		while (list[i] != 0) { 	/*
								 * 尋找到 0 的位置，然後返回上一個，例如[1, 4]第一個1會返回4，
								 * 這裡的4代表最後一個連線的是4，所以只要edge[1]==4就代表形成迴圈
								 */
			i = list[i];
		}
		return i;
	}
}
