package net.pierre.monrocq.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.pierre.monrocq.graphs.Edge;
import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class Kruskal {
	
	private Graph g;
	private Map<Node,Integer> subset;

	public Kruskal(Graph g) {
		this.g = g;
		this.subset = new HashMap<Node,Integer>();
	}
	
	public Map<Node, Node> solve(){
		Map<Node, Node> parents = new LinkedHashMap<Node, Node>();
		ArrayList<Edge> result = new ArrayList<Edge>();
		return parents;
	}
	
	public void find() {
		
	}
	
	public void union(int x, int y) {
	}
}
