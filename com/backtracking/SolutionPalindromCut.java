package com.backtracking;

public class SolutionPalindromCut {
	public int minCut(String a) {
		if (isPalindrome(a)) {
			return 0;
		}
		int min = 0;
		for (int i = 1; i < a.length(); i++) {
			min=minCut(a.substring(0, i))
					+ minCut(a.substring(i, a.length()))+1;
		}
		return min;

	}

	public boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
         SolutionPalindromCut sol = new SolutionPalindromCut();
         System.out.println(sol.minCut("ababb"));
	}
}
