package com.graph;

import java.util.List;

public class Vertex<T> {
	long id;

	public Vertex(long id1) {
		id = id1;
	}

	public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {

	}

	public Long getId() {
		return id;
	}

	public List<Edge<T>> getAllEdges() {
		
		return null;
	}

}
