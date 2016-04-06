package com.dp;

public class LongestPalindrome {
	/**
	 * Formula is if(input[i]==input[j]){ t[i][j]=2+t[i+1][j-1] else
	 * t[i][j]=Math.max(t[i][j-1],t[i+1][j]); }
	 */

	public static void longestPalindrome(String input1) {
		int m = input1.length();
		int[][] t = new int[m][m];
		for (int i = 0; i < m; i++) {
			t[i][i] = 1;
		}
		int l = 1;
		while (l <= m) {
			for (int i = 0; i < m - 1; i++) {
				// j=i+l;
				int j = l + i;
				if (j < m ) {
					if (input1.charAt(i) == input1.charAt(j)) {
						t[i][j] = 2 + t[i + 1][j - 1];
					} else {
						t[i][j] = Math.max(t[i][j - 1], t[i + 1][j]);
					}
				}
			}
			l++;
		}
		System.out.println(t[0][m - 1]);
	}

	public static void main(String[] args) {

		longestPalindrome("agbcba");
	}

}
