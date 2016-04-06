package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Colorful {
	static boolean flag = true;
	public int colorful(int a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int k = a;
		while (k != 0) {
			int r = k % 10;
			map.put(r, r);
			k /= 10;
		}
		findcolor(a, map, 1);
		System.out.println(map);
		return 1;
	}

	public int findcolor(int a, Map<Integer, Integer> map, int res) {
		if (a == 0) {
			return res;
		}
		while (a != 0) {
			int r = a % 10;
			if (map.containsKey(r)) {
				a /= 10;
				int k = findcolor(a / 10, map, res);
				res = k * r;
				map.put(a, res);
			}
		}
		return res;
	}

	// static
	public static void createColorful(int n, Map<Integer, Integer> map) {
		if (n == 0) {
			return;
		}
		int r = n % 10;
		if(map.containsKey(r)){
			flag=false;
		}
		map.put(r, r);
		int newNumber = n / 10;
		createColorful(newNumber, map);
		if (map.containsKey(newNumber)) {
			map.put(n, map.get(newNumber) * r);
		}
	}

	public static void main(String[] args) {
		// Colorful c = new Colorful();
		// c.colorful(236);
		//
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		createColorful(236, map);
		System.out.println(flag);
	

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				
				return o1.getValue()-o2.getValue();
			}
		});
//		map.put(0,0);
//		map.put(10, 10);
		System.out.println(map);
		final List<String> st= new ArrayList<String>();
		st.add("chandan");
		String s = st.get(0);
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		System.out.println(ch);
		String su = new String(ch);
		Collection<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> cg = new ArrayList<Integer>(a.subList(0, 1));
		
		
	}
}
