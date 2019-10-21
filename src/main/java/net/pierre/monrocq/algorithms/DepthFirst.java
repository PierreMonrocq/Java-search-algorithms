package net.pierre.monrocq.algorithms;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class DepthFirst {

	private Graph g;
	
	public DepthFirst(Graph g) {
		this.g = g;
	}
	
	public Set<Node> traversal(String root) {
		Node rootVertex = new Node(root);
	    Set<Node> visited = new LinkedHashSet<Node>();
	    Stack<Node> stack = new Stack<Node>();
	    stack.push(rootVertex);
	    while (!stack.isEmpty()) {
	        Node vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Node v : this.g.getAdjacentVertices(vertex.getLabel())) {              
	                stack.push(v);
	            }
	        }
	    }
	    return visited;
	}
	
	public Set<Node> search(String root, String goal){
		Set<Node> explored = new LinkedHashSet<Node>();
		Node rootVertex = new Node(root);
		Node goalVertex = new Node(goal);
		explored.add(rootVertex);
		if(rootVertex.equals(goalVertex)) {
			return explored;
		}
	    Stack<Node> frontier = new Stack<Node>();
	    frontier.push(rootVertex);
	    
	    while(!frontier.isEmpty()) {
	    	Node vertex = frontier.pop();
	    	explored.add(vertex);
	    	for(Node v: this.g.getAdjacentVertices(vertex.getLabel())) {
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
