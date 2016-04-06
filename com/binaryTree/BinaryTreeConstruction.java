package com.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeConstruction {
	private static Map<Integer,Integer> map = new HashMap<>();
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
	    for(int i=0;i<inorder.size();i++){
		    map.put(inorder.get(i),i);
		}
		TreeNode root = createTree(preorder,inorder,0,preorder.size()-1,0,inorder.size()-1);
		return root;
	}

	private TreeNode createTree(ArrayList<Integer> preorder,
			ArrayList<Integer> inorder,int preleft,int preright, int left, int right) {
		if(preleft>preright||left>right) return null;
		//index=0;
		int val=preorder.get(preleft);
		TreeNode root=  new TreeNode(preorder.get(preleft));
	    int k=map.get(val);
		root.left=createTree(preorder, inorder,preleft+1,preleft+k-left, left, k-1);
		root.right=createTree(preorder, inorder,preleft+(k-left)+1,preright,k+1, right);
		
		return root;
		//return null;
	}

		public static void main(String[] args) {
			BinaryTreeConstruction bt = new BinaryTreeConstruction();
			ArrayList<Integer> inorder= new ArrayList<Integer>();
			inorder.add(1);inorder.add(2);inorder.add(3);inorder.add(4);inorder.add(5);
			ArrayList<Integer> preorder= new ArrayList<Integer>();
			preorder.add(3);preorder.add(2);preorder.add(4);preorder.add(1);preorder.add(5);
			TreeNode root = bt.buildTree(preorder, inorder);
			//System.out.println(root.data);
			printInorder(root);
		}

		private static void printInorder(TreeNode root) {
			if(root==null)return ;
			printInorder(root.left);
			System.out.print(root.data+" ");
			printInorder(root.right);
			
		}
	}



