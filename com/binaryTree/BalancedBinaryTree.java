package com.binaryTree;

public class BalancedBinaryTree {
	
	public int isBalanced(TreeNode root){
		if(root==null){
			return 1;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		if(Math.abs(lh-rh)<=1 && isBalanced(root.left)==1 && 
				isBalanced(root.right)==1 ){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	
	private int height(TreeNode root) {
		if(root==null)
		return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left= new TreeNode(1);
		root.right= new TreeNode(3);
		BalancedBinaryTree bt  = new BalancedBinaryTree();
		System.out.println(bt.isBalanced(root)
				);
		
	}

}
