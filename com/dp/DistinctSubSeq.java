package com.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DistinctSubSeq {
	public int numDistinct(String S, String T) {
		int m = T.length();
		int n = S.length();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			t[0][i] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					t[i][j] = t[i-1][j-1];
				} else {
					t[i][j] = 1+Math.min(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return t[m][n];
	}
	public static void main(String[] args) {
		DistinctSubSeq st = new DistinctSubSeq();
		int k=st.numDistinct("rabbbit", "rabbit");System.out.println(k);
		ArrayList<Character> c = new ArrayList<Character>();
		c.add((char) 1);
		
	
	}
}
