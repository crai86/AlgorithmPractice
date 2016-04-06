package com.worldclass;

import java.util.HashMap;
import java.util.Map;

public class Solutiontest {
		public int lengthOfLongestSubstring(String s) {
		     if(s==null)
	            return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
		
	 
		return Math.max(pre, map.size());
		}
	
		public static void main(String[] args) {
			Solutiontest te = new Solutiontest();
			te.lengthOfLongestSubstring("abcabcbb");
			StringBuilder st = new StringBuilder();
			st.append("sgdsg");
			
			st=new StringBuilder("cghes");
			
		}

}
