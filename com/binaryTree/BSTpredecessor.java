package com.binaryTree;




public class BSTpredecessor {
	
	public static Node predesscor(Node root,Node n){
		if(n.left!=null){
			Node temp = n.left;
			while(temp.right!=null)temp=temp.right;
			return temp;
		}
		else{
			Node pre=null;
			while(root!=null){
				if(root.data<n.data){
					pre=root;
					root=root.right;
					
				}
				else{
					root=root.left;
				}
			}
			return pre;
		}
		
	}
	public static void main(String[] args) {
		Node root=new Node(15);
		root.left=new Node(10);
		root.right=new Node(20);
		root.right.right= new Node(21);
		root.left.right= new Node(12);
		root.left.left= new Node(8);
		
		System.out.println(predesscor(root, root).data);
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
