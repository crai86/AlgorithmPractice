package com.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LongestCommonSubSequence {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();
		findLongestSubSequence(input1, input2);
		File f = new File("");
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s =new String();
		while((s=buff.readLine())!=null){
			System.out.println(s);
		}
	}

	private static void findLongestSubSequence(String input1, String input2) {
		int[][] t = new int[input1.length() + 1][input2.length() + 1];
		int m = input1.length();
		int n = input2.length();

		for (int i = 0; i <= m; i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			t[0][j] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (input1.charAt(i - 1) != input2.charAt(j - 1)) {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				} else {
					t[i][j] = 1 + t[i - 1][j - 1];
				}
			}
		}
		StringBuffer st = new StringBuffer();
		for (int i = m, j = n; i > 0 && j > 0;) {
			if (t[i][j] != Math.max(t[i - 1][j], t[i][j - 1])) {
				st.insert(0, input1.charAt(i));
				i--;
			} else {
				j--;
			}

		}
		System.out.println(t[m][n] + " String is " + st.toString());
	}

}
