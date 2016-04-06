package com.binaryTree;

public class InvertBinaryTree {
	
	    public static TreeNode invertTree(TreeNode root) {
	        if(root==null) return null;
	        TreeNode temp =root.left;
	        root.left=root.right;
	        root.right=temp;
	        if(root.left!=null)
	        return invertTree(root.left);
	        else 
	        return invertTree(root.right);
	        
	    }
	    
	    public static void main(String[] args) {
			TreeNode root =  new TreeNode(4);
			root.left= new TreeNode(2);
			root.right= new TreeNode(7);
			root.left.left= new TreeNode(1);
			root.left.right= new TreeNode(3);
			root.right.left= new TreeNode(6);
			root.right.right= new TreeNode(9);
			TreeNode cur = root;
			printInorder(cur);
			System.out.println("&&&&&&&&&&&");
			invertTree(root);
			printInorder(root);
			root =  new TreeNode(4);
			System.out.println("&&&&&&&&&&&");
			invertTree(root);
			printInorder(root);
			
		}
	    
	    public static void printInorder(TreeNode root){
	    	if(root==null) return;
	    	printInorder(root.left);
	    	System.out.println(root.data);
	    	printInorder(root.right);
	    }

}
