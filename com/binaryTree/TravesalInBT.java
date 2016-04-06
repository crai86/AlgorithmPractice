package com.binaryTree;

public class TravesalInBT {
	
	public void inorder(Node root){
		if(root==null) return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	public void preorder(Node root){
		if(root==null)return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
		
	}
	public void postorder(Node root){
		if(root==null)return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);
	}
	
	public static void printKdown(Node root,int k ){
		if(root==null) return;
		if(k==0) System.out.println(root.data);
		printKdown(root, k-1);
		printKdown(root.right, k-1);
	}
	
	public static int printKanywhere(Node root,Node target,int k){
		if(root==null) return -1;
		if(root==target){
			printKdown(root, k); return 0;
		}
		int dl=printKanywhere(root.left,target,k-1);
		if(dl!=-1){
			if(dl+1==k){
				printKdown(root.right, k-dl-2);
			}
			return dl+1;
		}
		int dr=printKanywhere(root.right,target,k-1);
		if(dr!=-1){
			if(dr+1==k){
				printKdown(root.left, k-dr-2);
			}
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
		TravesalInBT bt = new TravesalInBT();
		bt.inorder(n);
		System.out.println("*********");
		bt.preorder(n);
		System.out.println("*********");
		bt.postorder(n);
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
