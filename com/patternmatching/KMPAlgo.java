package com.patternmatching;

public class KMPAlgo {

	public static void searchPattern(String text, String pattern) {
		int[] lps = createlpsArray(pattern);
		int i = 0;
		int j = 0;
		int m = text.length();
		while (i < m) {
			if (j < pattern.length() && pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == pattern.length()) {
				System.out.println("found at index" + (i - j));
				j = lps[j - 1];
			} else if (i < m && pattern.charAt(j)!= text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else
					i++;
			}
		}
	}

	public static int[] createlpsArray(String pattern) {
		int n = pattern.length();
		int j = 0;
		int i = 1;
		int[] lps = new int[n];
		while (i < n) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[i - 1];
				} else {
					lps[i] = 0;
				}
				i++;

			}
		}
		return lps;
	}

	public static void main(String[] args) {
		searchPattern("abxabcabcaby", "abadce");
	}

}
