package com.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTravesal {

	
	public static void main(String[] args) {
		LevelOrderTravesal lt = new LevelOrderTravesal();
		Node root = new Node(10);
		root.left=new Node(9);
		root.right=new Node(13);
		root.left.left=new Node(5);
		root.left.right=new Node(8);
		lt.levelordertravrsal(root);
		
	}
	public void levelordertravrsal(Node root){
		Node cur=root;
		Queue<Node> que= new LinkedList<Node>();
		while(cur!=null){
			System.out.print(cur.data+" ");
			if(cur.left!=null) que.add(cur.left);
			if(cur.right!=null) que.add(cur.right);
			cur=que.poll();
			
		}
	}
	
	static class Node {
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left= null;
			this.right=null;
		}
	}
}
