package com.dp;

public class PartionPalindrome {
	
	public static void partionpalindrome(String input){
		int m = input.length();
		int[][]t=new int[m][m];
		for(int i=0;i<m;i++){
			t[i][i]=0;
		}
		int l=1;
		while(l<=m){
			for(int i=0;i<m;i++){
				int j=l+i;
				if(j<m){
					if(ispalindrome(input.substring(i,j+1))){
						t[i][j]=0;
					}else{
						int min=Integer.MAX_VALUE;
						for(int k=0;k<j;k++){
							min=Math.min(min,Math.min(t[i][k], t[k+1][j]));
						}
						t[i][j]=1+min;
					}
				}
			}
			l++;
		}
		System.out.println(t[0][m-1]);
	}
	public static boolean ispalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		partionpalindrome("abcbm");
	}
}
