package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubSet {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> res = permute(a, 0);
		res.add(0, new ArrayList<Integer>());
		return res;
	}

	private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a, int i) {
		if (i == a.size() - 1) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> ag = new ArrayList<Integer>();
			ag.add(a.get(i));
			res.add(ag);
			return res;
		}
		ArrayList<ArrayList<Integer>> kres = permute(a, i + 1);
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add(a.get(i));
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		temp.add(t);
		for(ArrayList<Integer> ak:kres){
			ArrayList<Integer> ty = new ArrayList<Integer>();
			ty.add(a.get(i));
			ty.addAll(ak);
			temp.add(ty);
		}
		for(ArrayList<Integer> at :kres){
			temp.add(at);
		}
	
		return temp;

	}

	public static void main(String[] args) {
		SubSet st = new SubSet();
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		System.out.println(st.subsets(x));
	}
}
