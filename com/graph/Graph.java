package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	List<Edge<T>> edges;
	Map<Long, Vertex<T>> allvertex;
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		super();
		edges = new ArrayList<Edge<T>>();
		allvertex = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addVertex(Vertex<T> vertex) {
		if (allvertex.containsKey(vertex.getId())) {
			return;
		}
		allvertex.put(vertex.getId(), vertex);
		for (Edge<T> edge : vertex.getAllEdges()) {
			edges.add(edge);
		}

	}

	public Vertex<T> addSingleVertex(long id) {
		if (allvertex.containsKey(id)) {
			return allvertex.get(id);
		}
		Vertex<T> v = new Vertex<T>(id);
		allvertex.put(id, v);
		return v;
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> vertex1 = null;
		Vertex<T> vertex2 = null;
		if (allvertex.containsKey(id1)) {
			vertex1 = allvertex.get(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allvertex.put(id1, vertex1);
		}
		if (allvertex.containsKey(id2)) {
			vertex2 = allvertex.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allvertex.put(id2, vertex2);
		}
		Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
		edges.add(edge);
		vertex1.addAdjacentVertex(edge, vertex2);
		if (!isDirected) {
			vertex2.addAdjacentVertex(edge, vertex1);
		}

	}

	public List<Edge<T>> getAllEdges() {
		return edges;
	}

	public void setEdges(List<Edge<T>> edges) {
		this.edges = edges;
	}

	public Map<Long, Vertex<T>> getVertex() {
		return allvertex;
	}

	public void setVertex(Map<Long, Vertex<T>> vertex) {
		this.allvertex = vertex;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Edge<T> edge : getAllEdges()) {
			buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " "
					+ edge.getWeight());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}
