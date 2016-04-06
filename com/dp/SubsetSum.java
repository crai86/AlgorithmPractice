package com.dp;

public class SubsetSum {

	public boolean subsetsum(int[] input, int sum) {
		boolean[][] t = new boolean[input.length + 1][sum + 1];
		for (int i = 0; i <= input.length; i++) {
			t[0][i] = true;
		}
		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (input[i - 1] <= j) {
					t[i][j] = t[i - 1][j] || t[i - 1][j - input[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[input.length][sum];
	}

	public boolean isSubSetSum(int[] input, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (sum > 0 && n == 0) {
			return false;
		}
		if (sum > input[n - 1]) {
			return isSubSetSum(input, n - 1, sum);
		}
		return isSubSetSum(input, n - 1, sum)
				|| isSubSetSum(input, n - 1, sum - input[n - 1]);
	}
	public static void main(String[] args) {
		SubsetSum st = new SubsetSum();
		int[]input = {6,1,4,2,9,7};
		System.out.println(st.subsetsum(input, 7));
		
	}
}
