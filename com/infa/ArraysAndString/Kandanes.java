package com.infa.ArraysAndString;

public class Kandanes {
	
	public static int findMax(int[] a){
		int cursum=a[0],maxsum=a[0];
		for(int i=1;i<a.length;i++){
			cursum+=a[i];
			cursum=Math.max(a[i], cursum);
			maxsum=Math.max(cursum, maxsum);
		}
		return maxsum;
		
	}
	
	public static void main(String[] args) {
	  System.out.println(findMax(new int[]{2,-8,3,-2,4,-10}));	
	}

}
