package com.leetcode.challenge.june_21;

import java.util.ArrayList;
import java.util.List;

/**
 * 684.https://leetcode.com/problems/redundant-connection/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��25�� �U��10:39:19
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
		for (int[] edge : edges) {/* �N edge�̭����ơA�h���H�e���S���s�L */
			int x = find(list, edge[0]);
			int y = find(list, edge[1]);
			if (x == y)
				return edge;
			list[x] = y;
		}

		return null;
	}

	private int find(int[] list, int i) { /* �P�_�O�_���b���e�s�L�Alist[i]�s��m�A��^��m */
		while (list[i] != 0) { 	/*
								 * �M��� 0 ����m�A�M���^�W�@�ӡA�Ҧp[1, 4]�Ĥ@��1�|��^4�A
								 * �o�̪�4�N��̫�@�ӳs�u���O4�A�ҥH�u�nedge[1]==4�N�N��Φ��j��
								 */
			i = list[i];
		}
		return i;
	}
}
