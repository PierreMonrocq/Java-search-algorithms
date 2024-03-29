package net.pierre.monrocq;

import java.util.ArrayList;
import java.util.HashMap;

import net.pierre.monrocq.algorithms.Astar;
import net.pierre.monrocq.algorithms.BreadthFirst;
import net.pierre.monrocq.data.roumanie;
import net.pierre.monrocq.graphs.Edge;
import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Node;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Edge> roumanieEdges = roumanie.getEdges();
		ArrayList<Node> labels = roumanie.getLabels();
		
		Graph g = new Graph(labels,roumanieEdges);
		System.out.println(g);
		
		//BreadthFirst breadthFirst = new BreadthFirst(g);
		//DepthFirst df = new DepthFirst(g);
		//System.out.println(df.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
		//Prim p = new Prim(g);
		//System.out.println(uniformCost.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
		
		HashMap<Node, Integer> heuristic = roumanie.getFlydistancetobucarest();
		
		Astar astar = new Astar(g);
		System.out.println(astar.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name(), heuristic));
		
		BreadthFirst bfs = new BreadthFirst(g);
		System.out.println(bfs.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
		
				
		
		
		
	}
}