package com.sort;

import java.util.Scanner;

public class RadixSort {
	static int range = 10;// this is Range for Decimal .It can be 16 for Hexa
	static int[] output = new int[1000005];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		radixSort(a, n);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
	}

	static void countSort(int[] a, int n, int place) {

		int[] freq = new int[range];
		for (int i = 0; i < n; i++) {
			freq[(a[i] / place) % range]++;
		}
		for (int i = 1; i < range; i++) {
			freq[i] += freq[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			output[freq[(a[i] / place) % range] - 1] = a[i];
			freq[(a[i] / place) % range]--;
		}
		for (int i = 0; i < n; i++) {
			a[i] = output[i];
		}

	}

	static void radixSort(int[] a, int n) {
		int maxx = findMax(a);
		int mul = 1;
		while (maxx > 0) {
			countSort(a, n, mul);
			mul *= 10;
			maxx /= 10;
		}
	}

	private static int findMax(int[] a) {
		int maxx = Integer.MIN_VALUE;
		for (int i : a) {
			maxx = Math.max(maxx, i);
		}
		return maxx;
	}
}
