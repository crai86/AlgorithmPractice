package com.infa.solution;

import java.util.ArrayList;

public class Solution2 {
	public int removeDuplicates(ArrayList<Integer> a) {
		int i = 1, j = 0, count2 = 0;
		while (i < a.size()-1) {
			if(a.get(j).equals(a.get(i)) || a.get(i).equals(a.get(i+1) )){
				i++;
			}
			else {
				j++;
				a.set(j, a.get(i));
				i++;
			}
		}
		return j + 1;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
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
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		System.out.println("Hello" + s.removeDuplicates(a));
	}
}
