package com.dp;

import java.util.Scanner;

public class KnapSnackProblem {

	public static int knapssackprob(int[]v,int[]w,int W){
		int m =v.length;
		int n = W;
		int[][]t = new int[m+1][n+1];
		t[0][0]=0;
		for(int i=1;i<=n;i++){
			t[0][i]=0;
		}
		for(int i=0;i<=m;i++){
			t[i][0]=0;
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				
				if(w[i-1]<=j){
					t[i][j]=Math.max(v[i-1]+t[i-1][j-w[i-1]], t[i-1][j]);
				}else{
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[m][n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]w= new int[n];
		int[]v= new int[n];
		for(int i=0;i<n;i++){
			w[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			v[i]=sc.nextInt();
		}
		int W = sc.nextInt();
		System.out.println(knapssackprob(v, w, W));
	}
}
