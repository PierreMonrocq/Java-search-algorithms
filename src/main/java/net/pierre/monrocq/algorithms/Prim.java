package net.pierre.monrocq.algorithms;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.pierre.monrocq.graphs.Edge;
import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.MaximumSpanTree;
import net.pierre.monrocq.graphs.Node;

public class Prim {

	private Graph g;
	
	public Prim(Graph graph) {
		this.g = graph;
	}
	
	public MaximumSpanTree solve(){
		
		Map<Node, Edge> res = new LinkedHashMap<Node,Edge>();
		Map<Node, Integer> values = new LinkedHashMap<Node, Integer>();
		Map<Node, Boolean> notIncludedNodes = new LinkedHashMap<Node, Boolean>();
		
		
		ArrayList<Node> nodes = g.getGraphNodes();
		
		for (Node nd : nodes) {
		   values.putIfAbsent(nd,Integer.MAX_VALUE);
		   notIncludedNodes.putIfAbsent(nd, false);
		   res.putIfAbsent(nd, null);
		}
		
		
		Node key = values.keySet().iterator().next();//get First Key
		values.replace(key,0);
		
		for(int n=0; n < g.getAdjacencyVertices().size(); n++) {
			Node node = findMinKey(values, notIncludedNodes);
			notIncludedNodes.replace(node, true);
			
			for (Node v : this.g.getAdjacentVertices(node.getLabel())){
					if(notIncludedNodes.get(v) == false && v.getCost() < values.get(v)) {
						values.replace(v, v.getCost());
						Edge e = new Edge(v.getLabel(), node.getLabel(), values.get(v));
						res.put(v, e);
					}
			}
			
		}
		//for cleaner output, not very necessary
		ArrayList<Edge> mst = new ArrayList<Edge>();
		for(Map.Entry<Node,Edge> map : res.entrySet()){
			if(map.getValue() != null) {//ignoring the first edge
				mst.add(map.getValue());
			}

		}
		return new MaximumSpanTree(nodes,mst);
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