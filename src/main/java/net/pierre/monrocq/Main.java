package net.pierre.monrocq;

import java.util.ArrayList;

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
		System.out.println(uniformCost.search(roumanie.ARAD.name(), roumanie.BUCHAREST.name()));
	}
}