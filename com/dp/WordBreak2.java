package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
		ArrayList<String> res = new ArrayList<>();
		wordBreak(a, 0, b, res, new StringBuilder());
		return res;
	}

	public void wordBreak(String mainString, int start, ArrayList<String> dict,
			ArrayList<String> res, StringBuilder st) {
		if (start >= mainString.length()) {
			res.add(st.toString());
			return;
		}
		for (int i = start; i < mainString.length(); i++) {
			String s = mainString.substring(start, i + 1);
			if (dict.contains(s)) {
				int oldLen = st.length();
				if (st.length() == 0) {
					st.append(s);
				} else {
					st.append(" " + s);
				}
				wordBreak(mainString, i + 1, dict, res, st);
				st.setLength(oldLen);
			}
		}
	}

	public ArrayList<String> wordBreakDp(String s, ArrayList<String> dict) {
		// create an array of ArrayList<String>
		Set<String> foo = new HashSet<>(dict);
		ArrayList<String> dp[] = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (dp[i] == null)
				continue;

			for (String word : foo) {
				int len = word.length();
				int end = i + len;
				if (end > s.length())
					continue;

				if (s.substring(i, end).equals(word)) {
					if (dp[end] == null) {
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);
				}
			}
		}

		ArrayList<String> result = new ArrayList<String>();
		if (dp[s.length()] == null)
			return result;

		ArrayList<String> temp = new ArrayList<String>();
		dfs(dp, s.length(), result, temp);
		Collections.sort(result);
		return result;
	}

	private void dfs(List<String> dp[], int end, List<String> result,
			ArrayList<String> tmp) {
		if (end <= 0) {
			String path = tmp.get(tmp.size() - 1);
			for (int i = tmp.size() - 2; i >= 0; i--) {
				path += " " + tmp.get(i);
			}

			result.add(path);
			return;
		}

		for (String str : dp[end]) {
			tmp.add(str);
			dfs(dp, end - str.length(), result, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		WordBreak2 w2 = new WordBreak2();
		ArrayList<String> s = new ArrayList<String>();
		s.add("cats");
		s.add("cat");
		s.add("and");
		s.add("sand");
		s.add("dog");
		String st = new String("catsanddog");
		System.out.println(w2.wordBreak(st, s));
		System.out.println(w2.wordBreakDp(st, s));
	}
}
