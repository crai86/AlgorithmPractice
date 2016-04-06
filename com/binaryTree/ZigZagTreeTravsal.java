package com.binaryTree;

import java.util.Stack;

public class ZigZagTreeTravsal {
    /**
     * I am taking first right to left then left to right 
     * @param root
     */
	public static void zigzagTreeTravsal(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				TreeNode t = s1.peek();
				s1.pop();
				System.out.print(t.data+" ");
				if (t.left != null)
					s2.push(root.left);
				if (t.right != null)
					s2.push(root.right);
			}
			while (!s2.isEmpty()) {
				TreeNode t = s2.peek();
				s2.pop();
				System.out.print(t.data+" ");
				if (t.right != null)
					s1.push(t.right);
				if (t.left != null)
					s1.push(t.left);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		zigzagTreeTravsal(root);
	}

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			super();
			this.data = data;
		}

	}
}
