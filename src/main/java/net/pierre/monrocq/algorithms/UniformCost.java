package net.pierre.monrocq.algorithms;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Vertex;

public class UniformCost {
	
	private Graph g;
	
	public UniformCost(Graph g) {
		this.g = g;
	}
	
	public Set<Vertex> search(int root, int goal){
		Vertex rootVertex = new Vertex(root);
		Vertex goalVertex = new Vertex(goal);
		Set<Vertex> explored = new LinkedHashSet<Vertex>();
		PriorityQueue<Vertex> frontier = new PriorityQueue<Vertex>();//TODO add comparator to order by path cost
		 while (!frontier.isEmpty()) {
			 if(rootVertex.equals(goalVertex)) {
					return explored;
				}
		        Vertex node = frontier.poll();
		        explored.add(node);
		        //TODO
		        
		    }
		 return null;
		
	}

		
}
