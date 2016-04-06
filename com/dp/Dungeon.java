package com.dp;

public class Dungeon {

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 1;
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[] hp = new int[n];
		hp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
		for (int j = n - 2; j >= 0; j--) {
			hp[j] = Math.max(1, hp[j + 1] - dungeon[m - 1][j]);
		}
		// loop over all 
		for (int i = m - 2; i >= 0; i--) {
			hp[n - 1] = Math.max(1, hp[n - 1] - dungeon[i][n - 1]);
			for (int j = n - 2; j >= 0; j--) {
				hp[j] = Math.max(1, Math.min(hp[j], hp[j + 1]) - dungeon[i][j]);
			}
		}
		return hp[0];
	}

	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		int[][] dp = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		dungeon.calculateMinimumHP(dp);
	}

}
