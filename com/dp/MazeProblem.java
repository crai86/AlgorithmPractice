package com.dp;

public class MazeProblem {
	
	public static int minimuPath(int[][]v){
		int m=v.length;
		int n =v[0].length;
		int[][]t=new int[m][n];
		t[0][0]=v[0][0];
		for(int i=1;i<m;i++){
			t[i][0]=t[i-1][0]+v[i][0];
		}
		for(int j=1;j<n;j++){
			t[0][j]=t[0][j-1]+v[0][j];
		}
		for(int i=1;i<m-1;i++){
		 for(int j=1;j<n-1;j++){
			 if(v[i][j]!=-1){
				 t[i][j]=v[i][j]+max(t[i-1][j],t[i+1][j],t[i][j-1],t[i][j+1]);
			 }
		 }
		}
		return t[m-1][n-1];
	}

	private static int max(int i, int j, int k, int l) {
		return Math.max(Math.max(i, j),Math.max(j, k));
	//	return 0;
	}
	public static void main(String[] args) {
		int [][] v= new int[][]{
				{0,1,-1,1},
				{0,0,1,0},
				{1,1,-1,0},
				{0,0,1,0},
		};
		System.out.println(minimuPath(v));
	}

}
