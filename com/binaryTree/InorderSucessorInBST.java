package com.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class InorderSucessorInBST {

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(1);
		root.left.left = new Node(0);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		System.out.println(InordSuc(root, root.left).data);

	}

	public static ArrayList<LinkedList<Node>> connectAll(Node root) {
		ArrayList<LinkedList<Node>> res = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> list = new LinkedList<InorderSucessorInBST.Node>();
		list.add(root);
		int level = 0;
		res.add(0, list);
		while (true) {
			list = new LinkedList<InorderSucessorInBST.Node>();
			for (int i = 0; i < res.get(level).size(); i++) {
				Node n = res.get(level).get(i);
				if (n != null) {
					if (n.left != null)
						list.add(n.left);
					if (n.right != null)
						list.add(n.right);
				}
			}
			if (list.size() > 0) {
				res.add(level + 1, list);
			} else {
				break;
			}
			level++;

		}

		return res;
	}

	public static Node InordSuc(Node root, Node n) {
		Node suc = null;
		if (n.right != null)
			return min(n.right);

		while (root != null) {
			if (root.data > n.data) {
				suc = root;
				root = root.left;
			} else if (root.data < n.data) {
				root = root.right;
			} else
				break;
		}

		return suc;
	}

	private static Node min(Node n) {
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
