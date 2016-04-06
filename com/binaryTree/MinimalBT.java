package com.binaryTree;

public class MinimalBT {
	public static Node createTree(int[] a ,int start,int end){
		if(start>end) return null;
		int mid=(start+end)/2;
		Node root = new Node(a[mid]);
		root.left=createTree(a, start, mid-1);
		root.right=createTree(a, mid+1, end);
		return root;
	}
	public static void main(String[] args) {
		int[] a ={1,2,3,4,5};
		Node n = createTree(a, 0, a.length-1);
		System.out.println("root"+n.data);
		printInorder(n);
	}
	private static void printInorder(Node root) {
		if(root==null) return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
		
	}
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}

}
