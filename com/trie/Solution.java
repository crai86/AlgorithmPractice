package com.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static int numRange(ArrayList<Integer> a, int b, int c) {
		int count = 0, range = 0;
		int i = 0, j = 1, sum = a.get(0);
		while (i < a.size() - 1) {
			//System.out.println("sum:"+sum+"count:"+count);
			if (sum<= c) {
				j++;
				if(sum>=b){
				count++;
				//System.out.println("sum:"+sum+"count:"+count);
				}
			} else {
				i++;
				j = i + 1;
				sum = a.get(i);
			}
		}
       if(j>=a.size() && sum>=b && sum<=c ){
    	   count++;
       }
		return count;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		//80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 
		//22 80 97 78 45 23 38 38 93 83 16 91 69 18 82 60 50 61 70 15 6 52 90
//		a.add(22);
//		a.add(80);
//		a.add(97);
//		a.add(78);
//		a.add(45);
//		a.add(23);
//		a.add(38);
//		a.add(38);
//		a.add(93);
//		a.add(83);
//		a.add(16);
//		a.add(91);
//		a.add(69);
//		a.add(18);
//		a.add(82);
//		a.add(60);
//		a.add(50);
//		a.add(61);
//		a.add(70);
//		a.add(15);
//		a.add(6);
//		a.add(52);
//		a.add(90);
		
//		a.add(10);
		a.add(5);
		a.add(1);
		a.add(0);
		a.add(0);
		a.add(2);
		a.add(5);
		System.out.println(a.size());
		System.out.println(numRange(a, 6, 8));
		HashMap<Integer, Integer> in = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> entry :in.entrySet()){
			
		}
	}
}
