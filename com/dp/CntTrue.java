package com.dp;

public class CntTrue {
	private static int MOD = 1003;
	private static int[][] t;
	private static int[][] f;

	public int cnttrue(String a) {
           t = new int[a.length()][a.length()];
           f= new int[a.length()][a.length()];
		return Tr(0, a.length() - 1, a);
	}

	public int Tr(int i, int j, String s) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return s.charAt(i) == 'T' ? 1 : 0;
		}
		if (t[i][j] != 0) {
			return t[i][j];
		}
		int ans = 0;
		for (int k = i; k < j; ++k) {
			if (s.charAt(k) == '&')
				ans = ans + (Tr(i, k - 1, s) * Tr(k + 1, j, s));

			if (s.charAt(k) == '|')
				ans = ans + (Tr(i, k - 1, s) * Tr(k + 1, j, s))
						+ (Tr(i, k - 1, s) * Fa(k + 1, j, s))
						+ (Fa(i, k - 1, s) * Tr(k + 1, j, s)); // beacuase T OR
																// T = > T T OR
																// F = > T F OR
																// T => T

			if (s.charAt(k) == '^')
				ans = ans + (Tr(i, k - 1, s) * Fa(k + 1, j, s))
						+ (Fa(i, k - 1, s) * Tr(k + 1, j, s));

			if (ans >= MOD)
				ans %= MOD;
		}
		t[i][j] = ans;
		return ans;

	}

	int Fa(int i, int j, String exp) {
		if (i > j)
			return 0;
		if (i == j)
			return exp.charAt(i) == 'F' ? 1 : 0;
		if (f[i][j] != 0) {
			return f[i][j];
		}
		int ans = 0;
		for (int k = i; k < j; ++k) {
			if (exp.charAt(k) == '&')
				ans = ans + (Tr(i, k - 1, exp) * Fa(k + 1, j, exp))
						+ (Fa(i, k - 1, exp) * Tr(k + 1, j, exp))
						+ (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));
			if (exp.charAt(k) == '|')
				ans = ans + (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));

			if (exp.charAt(k) == '^')
				ans = ans + (Tr(i, k - 1, exp) * Tr(k + 1, j, exp))
						+ (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));

			if (ans >= MOD)
				ans %= MOD;
		}
		f[i][j] = ans;
		return ans;

	}
}
