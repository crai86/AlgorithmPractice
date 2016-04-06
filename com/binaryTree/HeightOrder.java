package com.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HeightOrder {

	public ArrayList<Integer> heightOrder(ArrayList<Integer> heights,
			ArrayList<Integer> inorders) {
		ArrayList<Mypair> pairs = new ArrayList<HeightOrder.Mypair>();
		int n = heights.size();
		Integer[] res = new Integer[n];
		for (int i = 0; i < n; i++) {
			pairs.add(new Mypair(heights.get(i), inorders.get(i)));
		}
		Collections.sort(pairs, new Comparator<Mypair>() {
			public int compare(Mypair o1, Mypair o2) {
				return o1.h - o2.h;
			}
		});
		for (int i = 0; i < n; i++) {
			Mypair current = pairs.get(i);
			int count = current.i;
			int j = 0;
			for (; j < n && count > 0; j++) {
				if (res[j] == null) {
					count--;
				}
			}
			while (res[j] != null)
				j++;
			res[j] = current.h;
		}
		return new ArrayList<Integer>(Arrays.asList(res));
	}
	
	public static void main(String[] args) {
		HeightOrder hi = new HeightOrder();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		heights.add(5);heights.add(3);heights.add(2);heights.add(1);heights.add(6);heights.add(4);
		ArrayList<Integer> inorders = new ArrayList<Integer>();
		inorders.add(0);inorders.add(1);inorders.add(2);inorders.add(0);inorders.add(3);inorders.add(2);
		System.out.println(hi.heightOrder(heights, inorders));
	}

	public static class Mypair {
		int h;
		int i;

		public Mypair(int h, int i) {
			this.h = h;
			this.i = i;
		}

		public String toString() {
			return h + " " + i;
		}
	}

}
