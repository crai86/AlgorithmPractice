package com.graph;

public class Edge<T> {
	Vertex<T> vertex1;
	Vertex<T> vertex2;
	int weight;
	boolean isDirected;

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected,
			int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;

	}

	public String getVertex1() {
		return vertex1.toString();
	}

	public String getVertex2() {
		// TODO Auto-generated method stub
		return vertex2.toString();
	}

	public int getWeight() {

		return weight;
	}

}
