package com.binaryTree;

public class PossibleBSTofNNodes {
	/** 
	 * asked in bloomreach and google which needs to be solved
	 * @param n
	 * @return
	 */

	public int findallways(int n){
		if(n==0){
			return 1;
		}
		if(n==1){
			return 1;
		}
		int sum=0,left=0,right=0;
		for(int i=1;i<=n;i++){
			left = findallways(i-1);
			right=findallways(n-i);
			sum+=left*right;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		PossibleBSTofNNodes bt = new PossibleBSTofNNodes();
		System.out.println(bt.findallways(5));
		String s =new String("8");
		System.out.println("Hello"+s.substring(1,1));
	}

}
