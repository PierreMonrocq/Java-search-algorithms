package net.pierre.monrocq.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class UniformCost {
	
	private Graph g;
	
	public UniformCost(Graph g) {
		this.g = g;
	}
	
	
	public List<Node> search(String root, String goal){
		List<Node> path = new ArrayList<Node>();
		Node rootNode = new Node(root);
		Node goalNode = new Node(goal);
		Set<Node> explored = new LinkedHashSet<Node>();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(rootNode);
		while (!frontier.isEmpty()) {
			 path.clear();
			 Node node = frontier.poll();
			 if(node.equals(goalNode)) {
				 return path;
			 }
			 explored.add(node);
			 path.add(node);//ADD node parent
			 for (Node child : this.g.getAdjacentVertices(node.getLabel())) {
				 if(!frontier.contains(child) && !explored.contains(child)) {
					 frontier.add(child);
				 }
				 else if(frontier.contains(child)) {
					 for(Node v : frontier) {
						 if(v.equals(child) && v.getCost() < child.getCost()) {
							 frontier.remove(v);
							 frontier.add(child);
						 }
					 }
				 }
			 }
        }
		return null;
	}	
}
