package com.binaryTree;


public class InorderSucessor {
	
	public static void main(String[] args) {
		Node n = new Node(5);
		n.left= new Node(2);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right=new Node(13);
		InorderSucessor sc = new InorderSucessor();
		Node t =sc.findInorderSuccessor(n, 4, n);
		System.out.println(t.data);
	}
	
	Node findRightSuccessor(Node root)
	{
	    while (root.left!=null)
	        root=root.left;
	    return root;
	}
	public Node findInorderSuccessor(Node root,int data,Node prev){
		if(root==null) return null;
//		
//		findInorderSuccessor(root.left, data, root);
		//System.out.println(prev.data);
		if(root.data==data){
			if(root.right!=null){
				return findRightSuccessor(root);
			}
			else {
				return prev;
			}
		}
		Node left = findInorderSuccessor(root.left, data, prev);
		if(left!=null){
			return left;
		}
		return findInorderSuccessor(root.right, data, prev);
	}
	static class Node{
		int data;
		Node left,right;
		public Node(int data) {
			this.data=data;
			this.left=null;this.right=null;
		}
		
	}

}
