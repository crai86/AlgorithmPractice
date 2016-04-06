package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordLadder2 {
	public ArrayList<ArrayList<String>> findLadders(String beginWord,
			String endWord, ArrayList<String> wordDict) {

		LinkedList<WordNode1> queue = new LinkedList<WordNode1>();
		ArrayList<String> res = new ArrayList<>();
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		res.add(beginWord);
		queue.add(new WordNode1(beginWord, res));

		wordDict.add(endWord);
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		while (!queue.isEmpty()) {
			WordNode1 top = queue.remove();
			String word = top.word;
			visited.put(word, true);
			if (word.equals(endWord)) {
				ans.add(top.words);
				continue;
			}

			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newWord = new String(arr);
					if (wordDict.contains(newWord)
							&& (!visited.containsKey(newWord) || !visited
									.get(newWord))) {
						ArrayList<String> temp2 = new ArrayList<String>(
								top.words);
						temp2.add(newWord);
						queue.add(new WordNode1(newWord, temp2));
						if(newWord.equals(endWord)){
							visited.put(newWord, false);
						}
					}

					arr[i] = temp;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		WordLadder2 addr1 = new WordLadder2();
		ArrayList<String> wordDict = new ArrayList<String>();
		String s = "baba abba aaba bbbb abaa abab aaab abba abba abba bbba aaab abaa baba baaa";
		String[] srr = s.split(" ");
		wordDict = new ArrayList<String>(Arrays.asList(srr));
		System.out.println(addr1.findLadders("bbaa", "babb", wordDict));

	}
}

class WordNode1 {
	String word;
	ArrayList<String> words = new ArrayList<String>();

	public WordNode1(String word, ArrayList<String> words) {
		super();
		this.word = word;
		this.words = words;
	}

	public String toString() {
		return word + " is";
	}
}
