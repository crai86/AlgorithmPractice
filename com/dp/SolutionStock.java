package com.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionStock {
	public static void findSol(Integer[] price) {
		int n = price.length;
		if (n == 1) {
			System.out.println(price[0]);
		}
		 int currMax = Integer.MIN_VALUE;
		 int profit=0;
         for (int j = n - 1; j >= 0; j--) {
               if (currMax < price[j]) {
                      currMax = price[j];
               }
               profit += (currMax - price[j]);
         }
         System.out.println(profit);
//		int i = 0;
//		int count = 0;
//		int totalcost=0;
//		int profit=0;
//		while (i < n - 1) {
//			while ((i < n - 1) && price[i] <= price[i + 1]) {
//				totalcost+=price[i];
//				count++;
//				i++;
//			}
//			int t=price[i]*count-totalcost;
//			profit=profit+t;
//			totalcost=0;
//			count=0;
//			if (i == n - 1) {
//				break;
//			}
//			i++;
//		}
//		System.out.println(profit);
//		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<ArrayList<Integer>> testcase = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			ArrayList<Integer> temp = new ArrayList<>();
			for (int k = 0; k < n; k++) {
				temp.add(sc.nextInt());
			}
			testcase.add(temp);
		}
		for (ArrayList<Integer> price : testcase) {
			findSol(price.toArray(new Integer[price.size()]));
		}
	}

	public static class Interval {
		int buy;
		int sell;
     public Interval(){
    	 this.buy=-1;
    	 this.sell=-1;
     }
	}
}