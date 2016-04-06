package com.worldclass;

import java.util.Arrays;

public class SolutionTe {
	static long minarea(int[] x, int[] y, int k) {
		if (k <= 0 || x.length < 2 || y.length < 2) {
			return 0;
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int kthXele = x[k - 1];
		int kthYele = y[k - 1];
		int minx = 0, miny = 0, maxx = 0, maxy = 0;
		int i = x[0];
		int j = y[0];
		if (i - 1 == 0) {
			minx = i - 2;
		} else {
			minx = i - 1;
		}
		if (j - 1 == 0) {
			miny = j - 2;
		} else {
			miny = j - 1;
		}

		if (kthXele + 1 == 0) {
			maxx = kthXele + 2;
		} else {
			maxx = kthXele + 1;
		}
		if (kthYele + 1 == 0) {
			maxy = kthYele + 2;
		} else {
			maxy = kthYele + 1;
		}
		int h = k;
		if (maxx > maxy) {
			while (h < x.length && maxx == x[h]) {
				maxx++;
				h++;
			}
			if (maxx == 0) {
				maxx++;
			}
		} else {
			h = k;
			while (h < x.length && maxy == y[h]) {
				maxy++;
				h++;
			}
			if (maxy == 0) {
				maxy++;
			}
		}
		h = k - 2;
		if (minx < miny) {
			while (h >= 0 && minx == x[h]) {
				minx--;
				h--;
			}
			if (minx == 0) {
				minx--;
			}
		} else {
			h = k - 2;
			while (h >= 0 && miny == y[h]) {
				miny--;
				h--;
			}
			if (miny == 0) {
				miny--;
			}
		}
		int length = Math.max(maxy, maxx) - Math.min(minx, miny);
		long ans = (long) length * (long) length;
		return ans;

	}

	public static void main(String[] args) {
		int[] x = { 0, 1, 2 };
		int[] y = { 0, 0, 3 };

		System.out.println(minarea(x, y, 1));

	}

}
