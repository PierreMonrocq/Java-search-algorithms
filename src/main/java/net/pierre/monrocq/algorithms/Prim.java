package net.pierre.monrocq.algorithms;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.MaximumSpanTree;
import net.pierre.monrocq.graphs.Node;

public class Prim {

	private Graph g;
	
	public Prim(Graph graph) {
		this.g = graph;
	}
	
	
	
	public Map<Node, Node> solve(){//TODO Later create A proper MST object
		Map<Node, Node> parents = new LinkedHashMap<Node, Node>();
		Map<Node, Integer> values = new LinkedHashMap<Node, Integer>();
		Map<Node, Boolean> notIncludedNodes = new LinkedHashMap<Node, Boolean>();
		
		for (Map.Entry<Node, List<Node>> entry : g.getAdjacencyVertices().entrySet()) {
		   values.putIfAbsent(entry.getKey(),Integer.MAX_VALUE);
		   notIncludedNodes.put(entry.getKey(), false);
		}
		Node key = values.keySet().iterator().next();//get First Key
		values.replace(key,0);
		for(int n=0; n < 20;n++) {
			Node node = findMinKey(values, notIncludedNodes);
			notIncludedNodes.replace(node, true);
			for (Node v : this.g.getAdjacentVertices(node.getLabel())){//ERROR loop
					if(notIncludedNodes.get(v) == false && v.getCost() < values.get(v)) {
						parents.put(node,v);
						System.out.println(v.getCost());
						values.replace(v, v.getCost());
					}
			}
			
		}
		return parents;
	}
	
	public static Node findMinKey( Map<Node, Integer> values ,Map<Node, Boolean> notIncludedNodes) {
		int min = Integer.MAX_VALUE;
		Node minNode = null;
		for(Node n : values.keySet()) {
			if((notIncludedNodes.get(n) == false) && min > values.get(n)) {
				min = values.get(n);
				minNode = n;
			}
		}
		return minNode;
	}
}
