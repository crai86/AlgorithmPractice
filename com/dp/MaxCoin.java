package com.dp;

import java.util.ArrayList;

/**
 * There are N coins (Assume N is even) in a line. Two players take turns to
 * take a coin from one of the ends of the line until there are no more coins
 * left. The player with the larger amount of money wins. Assume that you go
 * first.
 * 
 * Write a program which computes the maximum amount of money you can win.
 * 
 * @author crai
 *
 */
public class MaxCoin {
	public static int max = 0;

	public int maxcoin(ArrayList<Integer> a) {
		maxcoin(a, 0, 0);
		return max;
	}

	public int maxcoin(ArrayList<Integer> a, int index, int sum) {
		if (a.size() == 1) {
			return sum;
		}
		if (index % 2 == 0) {
			// add it to sum
			int maxI = 0;
			max = Math.max(
					maxcoin(new ArrayList<>(a.subList(1, a.size())), index + 1,
							sum + a.get(0)),
					maxcoin(new ArrayList<>(a.subList(0, a.size() - 1)),
							index + 1, sum + a.get(a.size() - 1)));
			return max;
		} else {
			// remove max element
			return Math.min(
					maxcoin(new ArrayList<>(a.subList(1, a.size())), index + 1,
							sum),
					maxcoin(new ArrayList<>(a.subList(0, a.size() - 1)),
							index + 1, sum));
		}
	}

	public int maxCoin2(ArrayList<Integer> a) {
		int C[][] = new int[100][100];
		int N = a.size();
		int x, y, z; // x = C[m+2][n], y = C[m+1][n-1], z = C[m][n-2]
		for (int i = 0; i < N; i++) {
			for (int m = 0, n = i; n < N; m++, n++) {
				// calculate x, y, z
				x = (m + 2 < N) ? C[m + 2][n] : 0;
				y = (m + 1 < N && n - 1 >= 0) ? C[m + 1][n - 1] : 0;
				z = (n - 1 > 0) ? C[m][n - 2] : 0;
				C[m][n] = Math.max(a.get(m) + Math.min(x, y),
						a.get(n) + Math.min(y, z));
				// For Debugging

			}
		}
		return C[0][N - 1];
	}

	public static void main(String[] args) {
		MaxCoin mx = new MaxCoin();
		ArrayList<Integer> a = new ArrayList<Integer>();
		// a.add(1);
		// a.add(100);
		// a.add(500);
		// a.add(10);
		a.add(26);
		a.add(88);
		a.add(57);
		a.add(26);
		a.add(65);
		a.add(60);
		a.add(55);
		a.add(40);
		System.out.println(mx.maxcoin(a));
	}
}
