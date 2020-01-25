package net.pierre.monrocq.algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class GreedyBestFirst {

	private Graph g;
	
	public GreedyBestFirst(Graph g) {
		this.g = g;
	}
	
	public List<Node> search(String root, String goal, HashMap<Node, Integer> heuristic){
		this.g = g.setNodeHeuristic(heuristic);
		
		Node rootNode = new Node(root);
		Node goalNode = new Node(goal);
		
		Set<Node> explored = new HashSet<Node>();
		
		Comparator<Node> nodeH =  new Comparator<Node>() {
	        public int compare(Node n1, Node n2) {
	            return n1.getHeuristicCost() - n2.getHeuristicCost();
	        }
	    };
	    
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(nodeH);
		frontier.add(rootNode);
		
		while (!frontier.isEmpty()) {
			
			 Node current = frontier.poll();
			 explored.add(current);
			 if(current.equals(goalNode)) {
				 return current.showPath();
			 }
			 
			 for (Node child : this.g.getAdjacentVertices(current.getLabel())) {
				  
				 if(!frontier.contains(child) && !explored.contains(child)) {
					 child.setParent(current);
					 frontier.add(child);
				 }
			 }
        }
		return null;
	}	
}
