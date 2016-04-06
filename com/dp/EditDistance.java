package com.dp;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2= sc.next();
		int k=findMinEditDistance(input1,input2,input1.length(),input2.length());
	System.out.println(k);
	System.out.println(editDistanceDp(input1, input2, input1.length(),input2.length()));
	}

	public static int editDistanceDp(String input1,String input2,int m,int n){
		int [][]t = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0){
					t[i][j]=j;
				}
				else if(j==0){
					t[i][j]=i;
				}
				else if(input1.charAt(i-1)==input2.charAt(j-1)){
					t[i][j]=t[i-1][j-1];
				}
				else{
					t[i][j]=1+min(t[i-1][j],t[i][j-1],t[i-1][j-1]);
				}
			}
		}
		return t[m][n];
	}
	private static int findMinEditDistance(String input1, String input2,int m,int n) {
		if(m==0) return n;
		if(n==0) return m;
		
		if(input1.charAt(m-1)==input2.charAt(n-1)){
			return findMinEditDistance(input1, input2, m-1, n-1);
		}
		else
			return 1+min(findMinEditDistance(input1, input2, m, n-1),
					findMinEditDistance(input1, input2, m-1, n),
					findMinEditDistance(input1, input2, m-1, n-1));
			
		
	}
	public static int min(int x,int y,int z){
		return Math.min(Math.min(x,y), z);
	}
}
