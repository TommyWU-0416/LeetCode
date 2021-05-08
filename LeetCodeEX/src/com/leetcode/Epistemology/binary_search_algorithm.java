package com.leetcode.Epistemology;

/**
 *
 * @author AaronWU
 * @version 創建時間：2021年5月8日 下午1:02:09
 * @since JDK8.0
 */
public class binary_search_algorithm {
	private static int[] array = {0,1,2,3,4,5,6,7,8,9,10};
	private static int target = 3;

	public static void main(String[] args) {
		binary_search_algorithm test = new binary_search_algorithm();
		test.linearSearch(array, target);
		test.binarySearch(array, target);
	}

	/**
	 * 1~100 每次都猜一半的地方，那麼會有幾次
	 * 先判斷 目標值與 (1+100)/2 大小關係，如果 大於目標，100就從50開始，如果無法整除的就取整數
	 * @param array
	 * @param target
	 */
	public void binarySearch(int[] array, int target) {
		int left = 0, middle = 0, right = array.length-1;
		while(left <= right) {
			middle = (left + right)/2;
			
			System.out.println("left:" + left + ", middle:" + middle + ", right:" + right);
			if(target == array[middle]) {
				break;
			}
			if(target > array[middle]) {
				left = middle + 1;
			}else if(target < array[middle]){
				right = middle - 1;
			}
		}
		
	}

	/**
	 * 一個個找
	 * 時間複雜度:O(n) 空間複雜度:O(1)
	 * 
	 * @param array
	 * @param target
	 */
	public void linearSearch(int[] array, int target) {
		int index = 0;
		while (index <= array.length - 1) {
			if (target == array[index]) {
				break;
			}
			index++;
		}
		System.out.println("count:" + (index + 1));
	}

}
