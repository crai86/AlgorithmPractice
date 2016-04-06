package com.binaryTree;

import java.util.ArrayList;

public class PrintPostOrder {
	
	public static void main(String[] args) {
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(4);in.add(2);in.add(5);in.add(1);in.add(3);in.add(6);
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);pre.add(2);pre.add(4);pre.add(5);pre.add(3);pre.add(6);
		PrintPostOrder p= new PrintPostOrder();
		p.printPostorder(in, 0, pre, 0, in.size());
	}
	
	public int search(ArrayList<Integer> in,int start,int key,int n){
		for(int i=0;i<n;i++){
			if(in.get(i)==key) return i;
		}
		return -1;
	}
	
	public void printPostorder(ArrayList<Integer>in,int in_start,ArrayList<Integer>pre
			,int pre_start,int n){
//		if(n<0) return;
		int root=search(in,in_start, pre.get(pre_start),n);
		if(root!=-1){
			printPostorder(in, in_start, pre, pre_start+1, root);
		}
		if(root!=n-1){
			//System.out.println("here is"+in.get(root)+" "+root);
				printPostorder(in, in_start+root+1, pre,pre_start+root+1, n-1-root);
			 }
//		else return;
		System.out.println(pre.get(pre_start)+" "+root+" "+in_start+" "+pre_start+" ");
		
     
	}

}
