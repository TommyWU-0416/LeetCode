package com.leetcode.recursion;

/**
 * �u�I�G�|���ѳ̤p���}�l�p��A���κ޶��ǡA�B�u�p�⥲�n�����D�C�]�@�}�l�O5�A�̫�|���j��1��0�}�l��A���n����function���I�s���A��l�����ޡ^
 * ���I�G�]�����_�I�sfunction���C�Ĳv�A�B�L�k�ۥѱ���p��T�A�|��������O����t�m
 * @author AaronWU
 * @version �Ыخɶ��G2021�~6��14�� �U��3:33:38
 * @since JDK8.0
 */
public class Recursion_Pratice {
	private int[] table = new int[1+5];
	private boolean[] solve = new boolean[1+5];
	private int count = 0;
	public static void main(String[] args) {
		Recursion_Pratice test = new Recursion_Pratice();
		
		System.out.println("��5���`�@�� " + test.f(5) + " �بB��");
	}

	/**
	 * ����k���Ӱ��D�N�O �S���h�x�s�w�g�p��L���ƭȡA�ɭP�n�A���s�p��@��
	 * �`�@���� 8 ��
	 * @param n
	 * @return
	 */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return 1;
//		else return f(n - 1) + f(n - 2);
//	}
	
	/**
	 * �C�@�ӭp��X�Ӫ�f(n)���|�x�s��n���A�]�������� solve[]�A�p�G�����L�N�strue�A�i�H�A�u�ơA�p�Gtable[n] >0 �N���p��L
	 * �`�@���� 6 ���A��֤F2��3������
	 * @param n
	 * @return
	 */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return table[n] = 1;
//		
//		if(solve[n]) return table[n];	/* �p�G�w�g�p��L�A�N�������x�s���ƭ�*/
//		table[n] = f(n-1) + f(n - 2);	/* �S��L�N�h�p��A�åB�x�s��table�ê�^ */
//		solve[n] = true;
//		return table[n];
//	}
	
	/**
	 * ²��solve�N��קאּ�P�_table�����ȬO�_����0�A�]0����l�ȡA�G�D0�h�N���p��L
	 * @param n
	 * @return
	 */
//	private int f(int n) {
//		System.out.println(count++);
//		if (n < 0  || n > 5)  return 0;
//		if (n == 0 || n == 1) return table[n] = 1;
//		
//		if(table[n] != 0) return table[n];	/* �p�G�w�g�p��L�A�N�������x�s���ƭ�*/
//		return f(n-1) + f(n - 2);			/* �S��L�N�h�p��A�åB�x�s��table�ê�^ */
//	}
	
	/**
	 * �N ���j �令 �j��A�P���j�S�ʬۤ�
	 * �u�I�G�����O���骺�i�ΩʡA���C����function
	 * ���I�G
	 * @param n
	 * @return
	 */
	private int f(int n) {
		table[0] = 1;
		table[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			System.out.println(count++);
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
	
	
}
