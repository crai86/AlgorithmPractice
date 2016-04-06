package com.backtracking;

public class SudokuSolver {
	int N = 9;
	int row = 0, col = 0;

	public boolean solveSudoko(int[][] grid) {
		if (!findUnassigned(grid)) {
			return true;
		}
		for (int num = 1; num <= 9; num++) {

			if (isSafe(grid, row, col, num)) {
				grid[row][col] = num;
				if (solveSudoko(grid)) {
					return true;
				} else {
					grid[row][col] = 0;
				}
			}
		}
		return false;
	}

	private boolean findUnassigned(int[][] grid) {
		for (row = 0; row < N; row++) {
			for (col = 0; col < N; col++) {
				if (grid[row][col] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSafe(int[][] grid, int row, int col, int num) {
		return !UsedInRow(grid, num) && !UsedInCol(grid,  num)
				&& !UsedInBox(grid, row - row % 3, col - col % 3, num);
	}

	private boolean UsedInBox(int[][] grid, int boxstartRow, int boxstartCol, int num) {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[i+boxstartRow][j+boxstartCol]==num) return true;
			}
		}
		return false;
	}

	private boolean UsedInCol(int[][] grid, int num) {
		for (int row2 = 0; row2 < N; row2++) {
			if (grid[row2][col] == num)
				return true;
		}
		return false;
	}

	private boolean UsedInRow(int[][] grid, int num) {
		for (int col2 = 0; col2 < N; col2++) {
			if (grid[row][col2] == num)
				return true;
		}
		return false;
	}

}
