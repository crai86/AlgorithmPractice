package com.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		findCountAnagram(s1, s2);

	}

	public static void findCountAnagram(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			if (map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
			} else {
				map.put(s1.charAt(i), 1);
			}
		}
		int count = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (map.containsKey(s2.charAt(i))) {
				map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
			} else {
				map.put(s2.charAt(i), 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			count += Math.abs(entry.getValue());
		}
		System.out.println(count);
	}
}
