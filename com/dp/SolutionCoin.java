package com.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionCoin {
	public static void findAllcombo(int[] coins, int sum) {
		int m = coins.length;
		int[][] t = new int[m][sum + 1];

		for (int i = 0; i <= sum; i++) {
			t[0][i] = i/coins[0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= coins[i]) {
					t[i][j] = Math.max(t[i - 1][j], 1 + t[i][j - coins[i]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		System.out.println(t[m - 1][sum]);
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] coins = new int[m];
		for (int i = 0; i < m; i++) {
			coins[i] = sc.nextInt();
		}
		findAllcombo(coins, n);
	}
}
