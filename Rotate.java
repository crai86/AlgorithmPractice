import java.util.Scanner;

public class Rotate {

	public static void rotateOnce(int[][] a) {
		int T = 0, B = a.length - 1, L = 0, R = a[0].length - 1;
		int dir = 0;
		int temp = a[T][L];
		int row = 0, col = 0;
		int m = B + 1;
		int n = R + 1;
		int prev, curr;
		while (row < m && col < n) {
			if (row + 1 == m || col + 1 == n) {
				break;
			}
			prev = a[row][col + 1];
			for (int i = row; i < m; i++) {
				curr = a[i][col];
				a[i][col] = prev;
				prev = curr;
			}
			col++;
			for (int i = col; i < n; i++) {
				curr = a[m - 1][i];
				a[m - 1][i] = prev;
				prev = curr;
			}
			m--;
			for (int i = m - 1; i >= row; i--) {
				curr = a[i][n - 1];
				a[i][n - 1] = prev;
				prev = curr;
			}
			n--;
			for (int i = n - 1; i >= col; i--) {
				curr = a[row][i];
				a[row][i] = prev;
				prev = curr;
			}
			row++;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println();
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int i = 0;
		while (i < 8) {
			rotateOnce(a);
			i++;
		}
		String s ="ab";
		System.out.println((int)s.charAt(0));
	}

}
