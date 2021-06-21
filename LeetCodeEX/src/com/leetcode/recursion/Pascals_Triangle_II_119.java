package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119.https://leetcode.com/problems/pascals-triangle-ii/submissions/
 * 
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��21�� �U��11:21:12
 * @since JDK8.0
 */
public class Pascals_Triangle_II_119 {
//	private static int rowIndex = 0;
//	private static int rowIndex = 1;
	private static int rowIndex = 2;
//	private static int rowIndex = 3;
//	private static int rowIndex = 4;
//	private static int rowIndex = 5;
//	private static int rowIndex = 6;	
//	private static int rowIndex = 7;
//	private static int rowIndex = 8;

	public static void main(String[] args) {
		Pascals_Triangle_II_119 test = new Pascals_Triangle_II_119();
		printArray(test.getRow(rowIndex));
	}

	/**
	 * �� Pascals_Triangle �Ϊ���k�@�ˡA�Ψ�ӰѼƧ@�Ȧs�A�u�O���T�w�o�ˬO�_���bO(K)��
	 * 
	 * Runtime : 1 ms, faster than 76.05%
	 * Memory Usage : 36.8 MB, less than 55.19%
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		int count = rowIndex + 1;
		List<Integer> list = new ArrayList<Integer>(rowIndex);

		if (count >= 1) {
			list.add(1);
			if (count >= 2) {
				for (int i = 2; i <= count; i++) {/* numRows = 4, i = 0~3 */
					List<Integer> sublist = new ArrayList<Integer>(i + 1);
					sublist.add(1); /* the first */
					for (int j = 1; j < i - 1; j++) {/* numsRow = 4, j = 1~2 */
						sublist.add(list.get(j - 1) + list.get(j));
					}
					sublist.add(1);

					list = sublist; /* the last */
				}
			}
		}
		return list;
	}

	/**
	 * �Q�ο��쪺�覡�A�N�Ŷ����bO(K)�U
	 * 
	 * Runtime :1 ms, faster than 76.05%
	 * Memory Usage : 36.7 MB, less than 67.29%
	 * 
	 * @param rowIndex
	 * @return
	 */
//	public List<Integer> getRow(int rowIndex) {
//		List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
//		for (int i = 0; i < rowIndex + 1; i++) {
//			list.add(1);
//		}
//
//		for (int j = 0; j < rowIndex + 1; j++) { /* �q0�}�l��A�]���n+1 */
//			for (int k = j - 1; k >= 1; k--) {
//
//				list.set(k, list.get(k - 1) + list.get(k));
//			}
//		}
//		return list;
//	}

	private static void printArray(List<Integer> res) {
		System.out.print("[ ");
		for (Integer context : res) {
			System.out.print(context + " ");
		}
		System.out.println("]");
	}
}
