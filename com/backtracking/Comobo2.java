package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Comobo2 {

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a,
			int b) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> t = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (i == 0 || a.get(i) != a.get(i - 1)) {
				t.add(a.get(i));
			}
		}
		t = new ArrayList<Integer>();
		findAllCombo(a, 0, t, 0, b,ans);
		return ans;
	}

	public void findAllCombo(ArrayList<Integer> a, int index,
			ArrayList<Integer> current, int currentSum, int target,ArrayList<ArrayList<Integer>> ans) {
		if (currentSum > target) {

			return;
		}

		if (currentSum == target) {
			ArrayList<Integer> k = new ArrayList<Integer>(current);
			
			if(!ans.contains(k))
			ans.add(k);
			return;
		}

		for (int i = index; i < a.size(); i++) {
			current.add(a.get(i));
			currentSum += a.get(i);
			findAllCombo(a, i + 1, current, currentSum, target,ans);
            current.remove(current.size()-1);
			currentSum -= a.get(i);
		}
	}

	public static void main(String[] args) {
		// 8, 10, 6, 11, 1, 16, 8
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(8);
		a.add(16);
		a.add(1);
		a.add(11);
		a.add(6);
		a.add(10);
		a.add(8);
		Comobo2 c = new Comobo2();
		c.combinationSum(a, 28);

	}
}
