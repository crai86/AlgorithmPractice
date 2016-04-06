package com.backtracking;

import java.util.ArrayList;

public class GenerateParenthesis {

	public ArrayList<String> generateParenthesis(int a) {
		ArrayList<String> res = new ArrayList<>();
		StringBuffer st = new StringBuffer();
		permute(a, 0, res, st);
		return res;
	}

	public void permute(int a, int count, ArrayList<String> res, StringBuffer st) {
		if (count > 0) {
			st.append(")");
			count--;
		}
		if (st.length() == 2 * a) {
			res.add(st.toString());
			int k = count / 2;
//			count=count-k;
			st.delete(k+1, st.length());
			return;
		}
		for (int i = count; i < a; i++) {
			st.append("(");
			count++;
			permute(a, count, res, st);
			// st.deleteCharAt(st.length()-1);
		}

	}

	public static void main(String[] args) {
		GenerateParenthesis gt = new GenerateParenthesis();
		gt.generateParenthesis(4);
	}
}
