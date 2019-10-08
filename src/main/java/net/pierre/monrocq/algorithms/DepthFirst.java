package net.pierre.monrocq.algorithms;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Vertex;

public class DepthFirst {

	private Graph g;
	
	public DepthFirst(Graph g) {
		this.g = g;
	}
	
	public Set<Vertex> traversal(int root) {
		Vertex rootVertex = new Vertex(root);
	    Set<Vertex> visited = new LinkedHashSet<Vertex>();
	    Stack<Vertex> stack = new Stack<Vertex>();
	    stack.push(rootVertex);
	    while (!stack.isEmpty()) {
	        Vertex vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : this.g.getAdjacentVertices(vertex.getId())) {              
	                stack.push(v);
	            }
	        }
	    }
	    return visited;
	}
	
	public Set<Vertex> search(int root, int goal){
		Set<Vertex> explored = new LinkedHashSet<Vertex>();
		Vertex rootVertex = new Vertex(root);
		Vertex goalVertex = new Vertex(goal);
		explored.add(rootVertex);
		if(rootVertex.equals(goalVertex)) {
			return explored;
		}
	    Stack<Vertex> frontier = new Stack<Vertex>();
	    frontier.push(rootVertex);
	    
	    while(!frontier.isEmpty()) {
	    	Vertex vertex = frontier.pop();
	    	explored.add(vertex);
	    	for(Vertex v: this.g.getAdjacentVertices(vertex.getId())) {
	    		if(!frontier.contains(v) && !explored.contains(v)) {
	    			frontier.push(v);
	    			if(v.equals(goalVertex)) {
	    				explored.add(v);
	    				return explored;
	    			}
	    			
	    		}

	    		
	    	}
	    }
	    return null;
	    
	}
	
}
