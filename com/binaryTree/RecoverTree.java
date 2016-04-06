package com.binaryTree;

import java.util.ArrayList;

public class RecoverTree {
	static TreeNode prev=null;
		public ArrayList<Integer> recoverTree(TreeNode a) {
		    ArrayList<Integer> res =new ArrayList<>();
		    getInorderTraversal(a,res);
		    return res;
		}
		public boolean getInorderTraversal(TreeNode root,ArrayList<Integer> res){
	        if(root!=null){
		    if(!getInorderTraversal(root.left,res)){
		        return false;
		    }
		    int prev_data=prev!=null?prev.data:123223;
		    System.out.println(prev_data);
		    if(prev!=null && prev.data>=root.data){
		        System.out.println("world is here");
		        res.add(root.data);
		        res.add(prev.data);
		        return false;
		    }
		    prev=root;
		    return getInorderTraversal(root.right,res);
		}
		return true;
	  }
	
 public static void main(String[] args) {
	TreeNode root = new TreeNode(4);
	root.left=new TreeNode(2);
	root.left.left=new TreeNode(1);
	root.right=new TreeNode(6);
	root.right.left=new TreeNode(3);
	root.right.right=new TreeNode(7);
	RecoverTree rt = new RecoverTree();
	rt.recoverTree(root);
}
}
