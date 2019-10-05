package net.pierre.monrocq.graphs;

public class Edge {
	
	//Not yet implemented
	private Vertex vertex1;
	private Vertex vertex2;
	private int cost;
	
	public Edge(Vertex v1, Vertex v2, int cost) {
		this.cost = cost;
		this.vertex1 = v1;
		this.vertex2 = v2;
	}

}
