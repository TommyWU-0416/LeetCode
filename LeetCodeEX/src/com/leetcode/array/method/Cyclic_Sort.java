package com.leetcode.array.method;

/**
 *
 * @author AaronWU
 * @version �Ыخɶ��G2021�~5��3�� �U��10:25:54
 * @since JDK8.0
 */
public class Cyclic_Sort {
	public static void main(String args[]){
		int a=6;
		int b=9;
		System.out.println("�洫�e�Aa="+a+" ,b="+b);
		swap(a,b);
		System.out.println("�洫��Aa="+a+" ,b="+b);
		}

	public static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
		System.out.println("swap��Ƥ��Aa="+a+" ,b="+b);
		}
}
