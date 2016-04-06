package com.dp;

import java.util.Scanner;

public class LongestIncreadingSequence {
	
	public static int findLongestIncreasingSequence(int[]a){
		int[] li = new int[a.length];
		for(int i=0;i<li.length;i++){
			li[i]=1;
		}
		for(int i=1;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]>a[j] && li[i]< (1+li[j])){
					li[i]=1+li[j];
				}
			}
		}
		int max=0;
		for(int i=0;i<li.length;i++){
			if(max<li[i]){
				max=li[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		System.out.println(findLongestIncreasingSequence(a));
	}

}
