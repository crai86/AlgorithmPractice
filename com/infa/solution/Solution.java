package com.infa.solution;

import java.util.ArrayList;

public class Solution {
	public int removeDuplicates(ArrayList<Integer> a) {
		// int j=1;
		ArrayList<Integer> res = new ArrayList<>();
		int j = 1;
		res.add(a.get(0));
		for (int i = 0; i < a.size(); i++) {
			if (j<a.size() && a.get(i) == a.get(j)) {
				while (j < a.size() && a.get(i) == a.get(j)) {
					j++;
				}
			} else {
				res.add(a.get(j));
			}
		}
		for (Integer i : res)
			System.out.println(i);

		return res.size();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(0);
		a.add(1);
		a.add(1);
		System.out.println("Hello" + s.removeDuplicates(a));

	}
}
