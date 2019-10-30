package net.pierre.monrocq.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class BreadthFirst {
	
	private Graph g;
	
	public BreadthFirst(Graph g) {
		this.g = g;
	}
	
	public Set<Node> traversal(String root){
		Node rootVertex = new Node(root);
		Set<Node> visited = new LinkedHashSet<Node>();
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(rootVertex);
	    visited.add(rootVertex);
	    while (!queue.isEmpty()) {
	        Node firstVertex = queue.poll();
	        for (Node v : this.g.getAdjacentVertices(firstVertex.getLabel())) {
	            if (!visited.contains(v)) {
	                visited.add(v);
	                queue.add(v);
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
	    Queue<Node> frontier = new LinkedList<Node>();
	    frontier.add(rootVertex);
	    while (!frontier.isEmpty()) {
	        Node node = frontier.poll();
	        explored.add(node);
	        for (Node child : this.g.getAdjacentVertices(node.getLabel())) {
	        	if(!frontier.contains(child) && !explored.contains(child)) {
	        		child.setParent(node);
	        		child.setCost(node.getCost()+child.getCost());//to update cost for each node
	    			if(child.equals(goalVertex)) {
	    				return child.showPath();
	    			}
	    			frontier.add(child);
	        	}
	        }
	    }
	    return null;
	}

}
