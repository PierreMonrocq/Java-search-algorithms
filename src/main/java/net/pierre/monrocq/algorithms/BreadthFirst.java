package net.pierre.monrocq.algorithms;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Vertex;

public class BreadthFirst {
	
	private Graph g;
	
	public BreadthFirst(Graph g) {
		this.g = g;
	}
	
	public Set<Vertex> traversal(int root, String...strings){
		Vertex rootVertex = new Vertex(root);
		if(strings.length != 0) {
			rootVertex.setLabel(strings[0]);
		}
		Set<Vertex> visited = new LinkedHashSet<Vertex>();
	    Queue<Vertex> queue = new LinkedList<Vertex>();
	    queue.add(rootVertex);
	    visited.add(rootVertex);
	    while (!queue.isEmpty()) {
	        Vertex firstVertex = queue.poll();
	        for (Vertex v : this.g.getAdjacentVertices(firstVertex.getId())) {
	            if (!visited.contains(v)) {
	                visited.add(v);
	                queue.add(v);
	            }
	        }
	    }
	    return visited;
	}

}
