package net.pierre.monrocq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.pierre.monrocq.algorithms.BellmanFord;
import net.pierre.monrocq.algorithms.GreedyBestFirst;
import net.pierre.monrocq.algorithms.Prim;
import net.pierre.monrocq.algorithms.UniformCost;
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
		UniformCost uniformCost = new UniformCost(g);
		//BreadthFirst breadthFirst = new BreadthFirst(g);
		//DepthFirst df = new DepthFirst(g);
		//System.out.println(df.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
		//Prim p = new Prim(g);
		//System.out.println(uniformCost.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
		
		GreedyBestFirst greedyBestFirst = new GreedyBestFirst(g);
		
		//distance vol oiseau
		HashMap<Node, Integer> flydist = roumanie.getFlydistancetobucarest();
		
		System.out.println(greedyBestFirst.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name(), flydist));
		
		
	}
}