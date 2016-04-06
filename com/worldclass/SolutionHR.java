package com.worldclass;

public class SolutionHR {
	static int kthSmallest(int arr[], int l, int r, int k) {
		if (k >= 0 && k <= r - l + 1) {
			int pos = parition(arr, l, r);
			if (pos - l == k - l)
				return arr[pos];
			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}
		return Integer.MAX_VALUE;
	}

	static int parition(int arr[], int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		// swap(arr[i], arr[r]);
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		return i;
	}
	
	public static void main(String[] args) {
		SolutionHR ht= new SolutionHR();
		int[]a = {0,2};
		System.out.println(kthSmallest(a, 0, a.length-1, 2));
	}

}
