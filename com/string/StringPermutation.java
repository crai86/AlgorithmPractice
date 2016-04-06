package com.string;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
	int count=0;
	public void permute(String s) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		char[] str = new char[map.size()];
		int[] count = new int[map.size()];
		int index=0;
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			str[index]=entry.getKey();
			count[index]=entry.getValue();
			index++;
		}
		char[] result = new char[s.length()];
		permuteUtil(result, str, count, 0);
	}

	private void permuteUtil(char[] result, char[] str, int[] count, int level) {
		if (level == result.length) {
			printArray(result);
			return;
		}
		for(int i=0;i<str.length;i++){
			if(count[i]==0){
				continue;
			}
			result[level]=str[i];
			count[i]--;
			permuteUtil(result, str, count, level+1);
			count[i]++;
		}

	}

	private void printArray(char[] result) {
		for (char c : result) {
			System.out.print(c);
		}
		System.out.println(":"+ ++count);

	}
	public static void main(String[] args) {
		StringPermutation st = new StringPermutation();
		st.permute("AABC");
	}

}
