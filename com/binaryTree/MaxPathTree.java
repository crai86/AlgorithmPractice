package com.binaryTree;

public class MaxPathTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// private static int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode a) {
		if (a == null) {
			return 0;
		}
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(a, max);
		return max[0];
	}

	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);

		int current = Math.max(root.val,
				Math.max(root.val + left, root.val + right));

		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

		return current;
	}
}
