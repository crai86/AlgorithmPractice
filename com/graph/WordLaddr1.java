package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WordLaddr1 {
	public int ladderLength(String beginWord, String endWord,
			ArrayList<String> wordDict) {
		Queue<WordNode> q = new LinkedList<WordNode>();
		q.add(new WordNode(beginWord, 1));
		wordDict.add(endWord);
		while (!q.isEmpty()) {
			WordNode top = q.peek();
			q.poll();
			String word = top.word;
			if (word.equals(endWord)) {
				return top.numofSteps;
			}
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char temp = arr[i];
					if (arr[i] != ch) {
						arr[i] = ch;
					}
					String t = new String(arr);
					if (wordDict.contains(t)) {
						q.add(new WordNode(t, top.numofSteps + 1));
						wordDict.remove(t);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		WordLaddr1 addr1 = new WordLaddr1();
		ArrayList<String> wordDict = new ArrayList<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		int k =addr1.ladderLength("hit", "cog", wordDict);
		System.out.println(k);
	}

}

class WordNode {
	String word;
	int numofSteps;

	public WordNode(String word, int numofSteps) {
		super();
		this.word = word;
		this.numofSteps = numofSteps;
	}

}
