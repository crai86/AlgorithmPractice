package com.binaryTree;

public class KthDistanceNode {

	public void printKdown(Node root,int k){
		if(root==null) return;
		if(k==0) System.out.println(root.data);
		printKdown(root.left, k-1);
		printKdown(root.right, k-1);
	}
	
	public int printKdistanceAnyside(Node root,Node target,int k){
		if(root==null) return -1;
		if(root==target) {
			printKdown(root, k);
			return 0;
		}
		int dl=printKdistanceAnyside(root.left,target, k);
		if(dl!=-1){
			if(dl+1==k){
				System.out.println(root.data);
			}
			else printKdown(root.right, k-dl-2); 
			return dl+1;	
		}
		
		
		int dr=printKdistanceAnyside(root.right, target, k);
		if(dr!=-1){
			if(dr+1==k){
				System.out.println(root.data);
			}
			else printKdown(root.left, k-dr-2); 
			return dr+1;	
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Node n = new Node(5);
		n.left= new Node(2);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right=new Node(13);
		KthDistanceNode k = new KthDistanceNode();
		k.printKdistanceAnyside(n,n.left.right, 3);
	}
	
	static class Node{
		int data;
		Node left,right;
		
		public Node(){
			
		}
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
}
