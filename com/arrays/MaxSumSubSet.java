package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumSubSet {

	public ArrayList<Integer> maxSumSubSet(ArrayList<Integer> a) {
		int max_range_left = -1, max_range_right = -1, cur_range_left = 0, cur_range_right = 0;
		int cur_sum = 0, max_sum = 0;
		while (cur_range_right < a.size()) {
			if (a.get(cur_range_right) < 0) {
				cur_range_left = cur_range_right + 1;
				cur_sum = 0;
			} else {
				cur_sum += a.get(cur_range_right);
				if (cur_sum > max_sum) {
					max_sum = cur_sum;
					max_range_left = cur_range_left;
					max_range_right = cur_range_right + 1;
				} else if (cur_sum == max_sum) {
					if (cur_range_left - cur_range_right + 1 > max_range_left
							- max_range_right) {
						max_range_left = cur_range_left;
						max_range_right = cur_range_right;
					}
				}
			}
			cur_range_right++;
		}
		if (max_range_left == -1 || max_range_right == -1) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = max_range_left; i < max_range_right; i++) {
			ans.add(a.get(i));
		}
		return ans;
	}

	public ArrayList<Integer> getRow(int N) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		if (N < 0)
			return new ArrayList<Integer>();
		for (int k = 0; A.size() <= N; k++) {
			ArrayList<Integer> new1 = new ArrayList<>();
			new1.add(1);
			for (int i = 1; i <= k - 1; i++) {
				int temp = (A.get(k - 1)).get(i - 1) + (A.get(k - 1)).get(i);
				new1.add(temp);
			}
			if (new1.size() - 1 <= N - 1)
				new1.add(1);
			A.add(new1);
		}
		return A.get(N);
	}

	public static void main(String[] args) {
		MaxSumSubSet st = new MaxSumSubSet();
		System.out.println(st.maxSumSubSet(new ArrayList<Integer>(Arrays
				.asList(new Integer[] { 1, 2, 5, -7, 2, 3 }))));
		System.out.println(st.getRow(0));
	}
}
