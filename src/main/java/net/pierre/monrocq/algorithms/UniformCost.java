package net.pierre.monrocq.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class UniformCost {
	
	private Graph g;
	
	public UniformCost(Graph g) {
		this.g = g;
	}
	
	public List<Node> search(String root, String goal){
		Node rootNode = new Node(root);
		Node goalNode = new Node(goal);
		Set<Node> explored = new HashSet<Node>();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(rootNode);
		while (!frontier.isEmpty()) {
			
			 Node current = frontier.poll();
			 explored.add(current);
			 if(current.equals(goalNode)) {
				 return current.showPath();
			 }
			 
			 for (Node child : this.g.getAdjacentVertices(current.getLabel())) {
				 child.setCost(current.getCost()+child.getCost());
				 
				 if(!frontier.contains(child) && !explored.contains(child)) {
					 child.setParent(current);
					 frontier.add(child);
				 }
				 else if((frontier.contains(child))&&(child.getCost()>(current.getCost()))) {
					 child.setParent(current);
					 frontier.remove(child);
					 frontier.add(child);
				 }
			 }
        }
		return null;
	}	
}
