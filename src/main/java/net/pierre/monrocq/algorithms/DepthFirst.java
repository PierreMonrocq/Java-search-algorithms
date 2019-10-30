package net.pierre.monrocq.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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
	
	public List<Node> search(String root, String goal){
		Set<Node> explored = new LinkedHashSet<Node>();
		Node rootVertex = new Node(root);
		Node goalVertex = new Node(goal);
		explored.add(rootVertex);
		if(rootVertex.equals(goalVertex)) {
			List<Node> res = new ArrayList<Node>();
			res.add(rootVertex);
			return res;
		}
	    Stack<Node> frontier = new Stack<Node>();
	    frontier.push(rootVertex);
	    
	    while(!frontier.isEmpty()) {
	    	Node node = frontier.pop();
	    	explored.add(node);
	    	for(Node child: this.g.getAdjacentVertices(node.getLabel())) {
	    		if(!frontier.contains(child) && !explored.contains(child)) {
	    			frontier.push(child);
	    			child.setParent(node);
	        		child.setCost(node.getCost()+child.getCost());//to update cost for each node
	    			if(child.equals(goalVertex)) {
	    				explored.add(child);
	    				return child.showPath();
	    			}
	    			
	    		}

	    		
	    	}
	    }
	    return null;
	    
	}
	
}
