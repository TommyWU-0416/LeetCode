package com.datastructures;

/**
 *
 * @author AaronWU
 * @version �Ыخɶ��G2021�~7��3�� �U��5:20:34
 * @since JDK8.0
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
