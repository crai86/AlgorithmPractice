package com.dp;

public class StocksWithKTransaction {

	public int maxProfit(int[] price, int k) {
		int[][] t = new int[k + 1][price.length];
		for (int i = 1; i <= k; i++) {
			int maxDiff = -price[0];
			for (int j = 1; j < price.length; j++) {
				
					t[i][j] = Math.max(t[i][j - 1], maxDiff + price[j]);
					maxDiff = Math.max(maxDiff, t[i - 1][j] - price[j]);
				
			}
		}
		return t[k][price.length - 1];
	}
	public static void main(String[] args) {
		int [] price={2,5,7,1,4,3,1,3};
		StocksWithKTransaction st = new StocksWithKTransaction();
		System.out.println("Max Profit is:"+st.maxProfit(price, 3));
	}
}
