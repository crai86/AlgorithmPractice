package com.backtracking;

import java.util.ArrayList;

public class PalindromePartition {

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		if (a == null || a.length() == 0) {
			return res;
		}
		ArrayList<String> t = new ArrayList<>();
		findAllcombo(a, 0, res, t);
		return res;

	}

	public void findAllcombo(String s, int index,
			ArrayList<ArrayList<String>> res, ArrayList<String> part) {
		if (index == s.length()) {
			ArrayList<String> temp = new ArrayList<>(part);
			res.add(temp);
			return;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			String str = s.substring(index, i);
			if (ispalindrome(str)) {
				part.add(str);
				findAllcombo(s, i, res, part);
				part.remove(part.size() - 1);
			}

		}

	}

	public boolean ispalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}
