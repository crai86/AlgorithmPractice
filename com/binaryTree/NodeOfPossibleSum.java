package com.binaryTree;

import java.util.ArrayList;

public class NodeOfPossibleSum {
	
	public static void findSum(Node root,int sum,ArrayList<Integer> buffer,int level){
		if(root==null) return ;
		int tmp=sum;
		buffer.add(root.data);
		for(int i=level;i>-1;i--){
			tmp-=buffer.get(i);
			if(tmp==0){
				//print it
				printNode(buffer,i,level);
			}
		}
		ArrayList<Integer> c1= (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2= (ArrayList<Integer>) buffer.clone();
		findSum(root.left, sum, c1, level+1);
		findSum(root.right, sum, c2, level+1);
	}
	
	private static void printNode(ArrayList<Integer> buffer, int i, int level) {
	  for(int i2=i;i2<=level;i2++){
		  System.out.print(buffer.get(i2)+" ");
	  }
	  System.out.println(" ");
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left=new Node(2);
		root.left.left=new Node(3);
		root.right=new Node(4);
		root.right.left=new Node(-4);
		root.right.right=new Node(5);
		findSum(root, 5, new ArrayList<Integer>(), 0);
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
