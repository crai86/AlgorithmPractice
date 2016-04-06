package com.binaryTree;




public class LCA {
	public Node lca(Node root,int n1,int n2){
		if(root==null) return null;
		if(root.data==n1||root.data==n2){
			return root;
		}
		Node lca=lca(root.left,n1,n2);
		Node rca=lca(root.right,n1,n2);
		if(lca!=null && rca!=null){
			return root;
		}
		return lca!=null?lca:rca;
	}
	
	public static void main(String[] args) {
		Node n = new Node(5);
		n.left= new Node(2);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right=new Node(13);
		LCA l = new LCA();
		Node t=l.lca(n, 4, 2);
		System.out.println(t.data);
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
