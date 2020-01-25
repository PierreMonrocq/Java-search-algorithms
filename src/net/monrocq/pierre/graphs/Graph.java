package net.monrocq.pierre.graphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Graph implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Map<Vertex, List<Vertex>> adjacencyVertices;

	public Graph() {
		this.adjacencyVertices = new HashMap<Vertex, List<Vertex>>();
	}
	
	public Graph(int... labels) {//Create a graph directly with vertex/vertices
		this.adjacencyVertices = new HashMap<Vertex, List<Vertex>>();
		for(int label : labels) {
			this.addVertex(label);
		}
	}
	
	public void addVertex(int vertex) {
		adjacencyVertices.putIfAbsent(new Vertex(vertex), new ArrayList<Vertex>());
	}
	
	public void removeVertex(int vertex) {
		Vertex v1 = new Vertex(vertex);
		adjacencyVertices.values().stream().forEach(e->e.remove(v1));
		adjacencyVertices.remove(new Vertex(vertex));
	}
	
	public void addEdge(int src, int dest) {
		Vertex vertex1 = new Vertex(src);
		Vertex vertex2 = new Vertex(dest);
		adjacencyVertices.get(vertex1).add(vertex2);
		adjacencyVertices.get(vertex2).add(vertex1);
	}
	
	public void addOrientedEdge(int src, int dest) {
		Vertex vertex1 = new Vertex(src);
		Vertex vertex2 = new Vertex(dest);
		adjacencyVertices.get(vertex1).add(vertex2);
	}
	
	public void addEdgeWithCost(int label1, int label2, int cost) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		vertex1.setCost(cost);
		vertex2.setCost(cost);
		adjacencyVertices.get(vertex1).add(vertex2);
		adjacencyVertices.get(vertex2).add(vertex1);
	}
	
	public void createEdgeMethod() {//TODO
		
	}
	
	public void removeEdge(int label1, int label2) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		List<Vertex> edge1 = adjacencyVertices.get(vertex1);
		List<Vertex> edge2 = adjacencyVertices.get(vertex2);
		if(edge1 != null) {
			edge1.remove(vertex2);
		}
		if(edge2 != null) {
			edge2.remove(vertex1);
		}	
	}
	
	public List<Vertex> getAdjacentVertices(int label){
		return adjacencyVertices.get(new Vertex(label));
	}
	
	@Override
	public String toString() {
		return adjacencyVertices.toString();
	}
	
}
