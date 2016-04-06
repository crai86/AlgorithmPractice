package com.binaryTree;

public class BSTtoBinary {
	public static int sum =0;
	
	public void inorder(Node root){
		if(root==null) return ;
		inorder(root.right);
		sum+=root.data;
		root.data=sum;
		//System.out.println(root.data);
		inorder(root.left);
	}
	public static void main(String[] args) {
		BSTtoBinary bt = new BSTtoBinary();
		Node n = new Node(5);
		Node n2 = new Node(2);
		Node n3= new Node(13);
		n.left=n2;
		n.right=n3;
		//bt.printInorder(n);
		System.out.println("***********");
		bt.inorder(n);
		//bt.printInorder(n);
		
	}
	
	public void printInorder(Node root){
		if(root==null) return;
		printInorder(root.left);
		System.out.println(root.data);
	    printInorder(root.right);
	}
	
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			
			this.data=data;
			this.left=null;
			this.right=null;
		//	return n;
		}
		public Node(){
			
		}
		public static Node newNode(int data){
			Node n = new Node();
			n.data=data;
			n.left=null;
			n.right=null;
			return n;
		}
	}

}
