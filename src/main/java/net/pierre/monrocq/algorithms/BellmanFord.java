package net.pierre.monrocq.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class BellmanFord {

	private Graph g;
	
	public BellmanFord(Graph g) {
		this.g = g;
	}
	
	public Map<Node,Integer> search(String source){
		
		Node sourceNode = new Node(source);
		
		Map<Node,Integer> distance = new HashMap<Node,Integer>();
		
		for (Map.Entry<Node, List<Node>> entry : g.getAdjacencyVertices().entrySet()) {
			   distance.putIfAbsent(entry.getKey(),Integer.MAX_VALUE);
		}
		distance.replace(sourceNode, 0);//Distance from source itself
		
		for (int i = 1; i < g.getAdjacencyVertices().size()-1; ++i) { 
			for(Map.Entry<Node, List<Node>> entry : g.getAdjacencyVertices().entrySet()) {
				Node n = entry.getKey();
				for(Node v : this.g.getAdjacentVertices(n.getLabel())){
					if(distance.get(n) != Integer.MAX_VALUE && distance.get(n) + v.getCost() < distance.get(v)) {
						distance.replace(v,distance.get(n) + v.getCost());
						
					}
				}
			}
		}
		
		//check for negatives cycles
		for(Map.Entry<Node, List<Node>> entry : g.getAdjacencyVertices().entrySet()) {
			Node n = entry.getKey();
			for(Node v : this.g.getAdjacentVertices(n.getLabel())){
				if(distance.get(n) != Integer.MAX_VALUE && distance.get(n) + v.getCost() < distance.get(v)) {
					return null;
					
				}
			}
		}
		
		return distance;
		
		
	}
}
