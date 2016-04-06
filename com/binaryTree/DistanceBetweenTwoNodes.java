package com.binaryTree;





public class DistanceBetweenTwoNodes {
	
	private static int distance=0,d1=-1,d2=-1;
	/**
	 * Idea is distance between two nodes is find distance from root to node1
	 * d1, distance from root to node2 is d2 and distance from lca as dl
	 * total distance= d1+d2-2*dl;
	 * @author crai
	 *
	 */
	public int findlevel(Node root,int k,int level){
		if(root==null) return -1;
		if(root.data==k) return level;
		int l= findlevel(root.left, k, level+1);
		return l!=-1?l:findlevel(root.right, k, level+1);
	}
	
	public Node distancebet2node(Node root,int n1,int n2,int level){
		if(root==null) return null;
		if(root.data==n1){
			d1=level;
			return root;
		}
		if(root.data==n2){
			d2=level;
			return root;
		}
		Node lca=distancebet2node(root.left,n1,n2,level+1);
		Node rca=distancebet2node(root.right,n1,n2,level+1);
		if(lca!=null && rca!=null){
			distance=d1+d2-2*level;
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
		DistanceBetweenTwoNodes db = new DistanceBetweenTwoNodes();
		System.out.println(db.findlevel(n, n.left.right.data, 0));
		int n1 =1,n2=4;
		Node lca =db.distancebet2node(n,n1,n2,0);
//		System.out.println(d1+""+d2);
		if(d1!=-1 && d2!=-1){
			System.out.println(distance);
		}
		if(d1!=-1){
			System.out.println(db.findlevel(lca,n2,0));
		}
		if(d2!=-1){
			System.out.println(db.findlevel(lca,n1,0));
		}
		
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
