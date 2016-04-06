package com.graph;

import java.util.HashMap;
import java.util.Map;

public class DisJointSet {
	Map<Long, Node> allnodes = new HashMap<Long, DisJointSet.Node>();

	static class Node {
		int rank;
		long data;
		Node parent;

		public String toString() {
			return "data:" + this.data + " ";
		}
	}

	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		allnodes.put(data, node);
	}

	public Node findset(long data) {
		Node node = allnodes.get(data);
		return findset(node);
	}

	public Node findset(Node node) {
		if (node.parent == node) {
			return node;
		}
		node.parent = findset(node.parent);
		return node.parent;
	}

	public void union(long data1, long data2) {
		Node node1 = allnodes.get(data1);
		Node node2 = allnodes.get(data2);
		Node parent1 = findset(node1);
		Node parent2 = findset(node2);
		if (parent1.data == parent2.data) {
			return;
		}
		if (parent1.rank >= parent2.rank) {
			parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1
					: parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
	}

	public static void main(String args[]) {
		DisJointSet ds = new DisJointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findset(1));
		System.out.println(ds.findset(2));
		System.out.println(ds.findset(3));
		System.out.println(ds.findset(4));
		System.out.println(ds.findset(5));
		System.out.println(ds.findset(6));
		System.out.println(ds.findset(7));
		System.out.println((double) Math.round(1.87808775e+02 * 10) / 10);
		System.out.println(Math.round(1.87808775e+02));

	}

}
