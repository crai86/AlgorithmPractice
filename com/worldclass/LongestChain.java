package com.worldclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LongestChain {
	private List<String> words;

	public int longestChain(List<String> words) {
		words = new ArrayList<String>(words);
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		HashMap<Node, Integer> chainlengths = new HashMap<Node, Integer>();
		for (String word : words) {
			Node node = new Node(word);
			nodes.put(word, node);
		}
		for (Map.Entry<String, Node> entry : nodes.entrySet()) {
			chainlengths.put(entry.getValue(), 0);
		}
		int n = words.size();
		for (int i = 0; i < n; i++) {
			String word = words.get(i);
			int wordsize = word.length();
			for (int j = 0; j < wordsize; j++) {
				String tmptStr = trimCharcter(word, j);
				if (nodes.containsKey(tmptStr)) {
					Node t = nodes.get(tmptStr);
					nodes.get(word).addChild(t);
				}

			}
		}
		int answer = 0;
		for (Map.Entry<Node, Integer> allNode : chainlengths.entrySet()) {
			Node node = allNode.getKey();
			int longestPath = findLongestPath(node, chainlengths);
			chainlengths.put(node, longestPath);

			if (longestPath > answer) {
				answer = longestPath;
			}
		}

		System.out.println(chainlengths);
		return answer;
	}

	private String trimCharcter(String word, int j) {
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (i == j)
				continue;
			st.append(word.charAt(i));
		}
		return st.toString();
	}

	private int findLongestPath(Node n, Map<Node, Integer> longestpathNodes) {
		int computed = longestpathNodes.get(n);
		if (computed != 0) {
			return computed;
		}
		List<Node> children = n.getChildren();
		//base case
		if (children.size() == 0) {
			longestpathNodes.put(n, 1);
			return 1;
		}
		int childPath = 0;
		for (Node child : children) {
			int childLongestPath = findLongestPath(child, longestpathNodes);
			if (childLongestPath > childPath) {
				childPath = childLongestPath;
			}
		}
		assert (childPath > 0);
		longestpathNodes.put(n, childPath + 1);
		return 1 + childPath;
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String word = input.next();
			if(word.equals("exit")) break;
			words.add(word);
		}

		int answer = new LongestChain().longestChain(words);
		System.out.println("Longest chain: " + answer);
	}

}
