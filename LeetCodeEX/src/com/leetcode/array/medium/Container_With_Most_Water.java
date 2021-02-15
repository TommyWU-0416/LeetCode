package com.leetcode.array.medium;


/**
 *
 * @author �d���
 * @version �Ыخɶ��G2020�~1��21�� �U��5:48:08
 * @since JDK8.0
 */
public class Container_With_Most_Water {

	public static void main(String[] args) {
		int[] height = {1,2,100,1,1,1,1,1,2};
		System.out.println(maxArea2(height) );
	}
	
	/**
	 * time:O(n^2) space:O(1)
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int sizeOfheight = height.length;
		int area = 0;
		for (int i = 0; i < sizeOfheight; i++) {
			for (int j = i + 1; j < sizeOfheight; j++) {
				int length =  j - i;
				
				System.out.print("[A" + i+j +"]*" + length + "=" + minVerticalLine(height[i], height[j]) * length + " ");
				if(area < minVerticalLine(height[i], height[j]) * length) {
					area = minVerticalLine(height[i], height[j]) * length;
				}
			}
			System.out.println();
		}
		return area;
	}

	public static int minVerticalLine(int a, int b) {
		return (a > b) ? b : a;
	}
	
	/**
	 * �C�@�ӳ̤p�����׭n�гy�̤j�����n�h�O�Z���V���V�n
	 * �]���u�n�̤p���ת����n�⧹�A�h�i�H�i��U�@�ӡA�p���L���n
	 * time:O(n) space:O(1)
	 * @param height
	 * @return
	 */
	public static int maxArea2(int[] height) {
		int maxarea = 0, l = 0, r = height.length-1;
		while(l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r])*(r-l));
			if(height[l] < height[r]) {
				l++;
			}else {
				r--;
			}
		}
		return maxarea;
	}
}
