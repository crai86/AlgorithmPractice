package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {

	private boolean visited[][];
	private int mLen;
	private ArrayList<String> A;
	private String B;
	private int m, n;
	private final static int di[] = new int[] { 1, -1, 0, 0 };
	private final static int dj[] = new int[] { 0, 0, -1, 1 };
 /**
  *  This is implementaion where words may be repeated 
  * @param A
  * @param B
  * @return
  */
	public int exist(ArrayList<String> A, String B) {

		if (A == null || B == null)
			return 0;

		m = A.size();
		n = A.get(0).length();
		mLen = B.length();
		this.A = A;
		this.B = B;

		visited = new boolean[m][n];
		boolean status = false;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				status = find(i, j, 0);
				if (status)
					return 1;
			}
		}

		return 0;

	}

	public boolean find(int i, int j, int index) {

		if (index == mLen)
			return true;

		if (index < 0 || index > mLen)
			return false;

		if (A.get(i).charAt(j) != B.charAt(index))
			return false;

		int nI, nJ;
		boolean status = false;
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			nI = i + di[k];
			nJ = j + dj[k];
			if (boundsCheck(nI, nJ)) {
				status = find(nI, nJ, index + 1);
				if (status)
					break;
			}
		}

		visited[i][j] = false;

		return status;

	}

	public boolean boundsCheck(int i, int j) {

		if (i < 0 || j < 0 || i >= m || j >= n)
			return false;

		return true;
	}

	public static void main(String[] args) {
		String[] s = new String[] { "FEDCBECD", "FABBGACG", "CDEDGAEC",
				"BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF" };
		String b = "BCDCB";
		ArrayList<String> as = new ArrayList<String>(Arrays.asList(s));
		System.out.println(as);
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(as, b));
		;
	}

}