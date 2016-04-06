package com.dp;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * 
 * @author crai
 *
 */
public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int m = triangle.size();
		int l = triangle.size() - 1;
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				total[j] = triangle.get(i).get(j)
						+ Math.min(total[j], total[j + 1]);
			}
		}
		return total[0];
	}

	public static void main(String[] args) {
		Triangle tri = new Triangle();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add(2);
		res.add(t);
		t = new ArrayList<Integer>();
		t.add(3);
		t.add(4);
		res.add(t);
		t = new ArrayList<Integer>();
		t.add(6);
		t.add(5);
		t.add(7);
		res.add(t);
		t = new ArrayList<Integer>();
		t.add(4);
		t.add(1);
		t.add(8);
		t.add(3);
		res.add(t);
		System.out.println(tri.minimumTotal(res));
		// /
		res = new ArrayList<ArrayList<Integer>>();
		t = new ArrayList<Integer>();
		t.add(-2);
		t.add(-3);
		t.add(3);
		res.add(t);
		t = new ArrayList<Integer>();
		t.add(-5);
		t.add(-10);
		t.add(1);
		res.add(t);
		t = new ArrayList<Integer>();
		t.add(10);
		t.add(30);
		t.add(-5);
		res.add(t);
		//System.out.println(tri.calculateMinimumHP(res));

	}
}
