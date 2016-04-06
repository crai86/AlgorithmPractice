package com.backtracking;

public class RegexMatching {

	public int isMatch(final String s, final String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0 ? 1 : 0;
		}
		// this is case for if pattern length is 1 or next string after 1st character is not star
		if (p.length() == 1 || p.charAt(1) != '*') {
			// case 1:if p length is 1 and s.length==0
			// case 2: not a dot character and it does not match with pattern s
			if (s.length() < 1|| (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
				return 0;
			}
			return isMatch(s.substring(1), p.substring(1));
		} else {
			// if second character is *
			// We will keep looping on s.length till the match found
			int len = s.length();

			int i = -1;
			while (i < len
					&& (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s
							.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2)) == 1)
					return 1;
				i++;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		RegexMatching mt = new RegexMatching();
		System.out.println(mt.isMatch("abbc", "ab*b."));
		final String su = new String("great");
		System.out.println(su.substring(2));
	}

}
