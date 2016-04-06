package com.worldclass;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String word;
	private List<Node> children;

	public Node(String word) {
		this.word = word;
		children = new ArrayList<Node>();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void addChild(Node n) {
		children.add(n);
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public String toString() {
		return "<node " + word + "/>";
	}
}
