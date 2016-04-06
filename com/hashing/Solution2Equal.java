package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution2Equal {
	public ArrayList<Integer> equal(ArrayList<Integer> a) {
		ArrayList<Integer> res = null;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < a.size(); i++) {
			for (int y = i + 1; y < a.size(); y++) {
				int sum = a.get(i) + a.get(y);
				if (map.containsKey(sum)) {
					ArrayList<Integer> pair = map.get(sum);
					if (pair.get(0) != i && pair.get(1) != y
							&& pair.get(0) != y && pair.get(1) != i) {
						ArrayList<Integer> _temp = new ArrayList<>();
						_temp.add(pair.get(0));
						_temp.add(pair.get(1));
						_temp.add(i);
						_temp.add(y);

						if (res == null)
							res = _temp;
						else {
							for (int k = 0; k < 4; k++) {
								if (res.get(k) < _temp.get(k)) {
									break;
								} else if (res.get(k) > _temp.get(k)) {
									res = _temp;
									break;
								}
							}
						}

					}
				} else {
					ArrayList<Integer> at = new ArrayList<Integer>();
					at.add(i);
					at.add(y);
					map.put(sum, at);
				}
			}
		}

		return res;

	}

	public static void main(String[] args) {
		Solution2Equal ew = new Solution2Equal();
		// 3, 4, 7, 1, 2, 9, 8
		ArrayList<Integer> at = new ArrayList<Integer>() {
			{
				add(3);
				add(4);
				add(7);
				add(1);
				add(2);
				add(9);
				add(8);
			}
		};
		System.out.println(ew.equal(at));
	}

	public class Pair implements Comparable<Pair> {
		int one;
		int two;

		public Pair(int o, int t) {
			one = o;
			two = t;
		}

		public String toString() {
			return "Pair:{" + this.one + "," + this.two + "}";
		}

		@Override
		public int compareTo(Pair o) {

			return this.one - o.one;
		}

	}
}
