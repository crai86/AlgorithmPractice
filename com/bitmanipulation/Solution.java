package com.bitmanipulation;

public class Solution {
	
	public long revnum(long a){
	 long revnum=0;
	 
	 int NO_OF_BITS=32;
	 for(int i=0;i<NO_OF_BITS;i++){
		 long temp= a& (1<<i);
		 if(temp !=0){
			 revnum|=((long)1<<((NO_OF_BITS-1)-i));
		 }
		 
	 }
	 return revnum;
	}
	public static void main(String[] args) {
		System.out.println((long)1<<31);
		Solution s = new Solution();
		System.out.println(s.revnum(3));
	}

}
