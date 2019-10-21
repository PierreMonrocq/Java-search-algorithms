package net.pierre.monrocq;

import java.util.ArrayList;
import net.pierre.monrocq.data.roumanie;
import net.pierre.monrocq.graphs.Edge;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		
		ArrayList<Edge> roumanieEdges = roumanie.getEdges();
		ArrayList<String> labels = roumanie.getLabels();
		
		System.out.println(roumanieEdges.toString());
		//Graph roumanie = new Graph(city);
		
		//Graph roumanie = Graph.load("roumanie.txt");
		
		//DepthFirst depthFirst = new DepthFirst(roumanie);
		
		//Set<Vertex> solution = depthFirst.search(ARAD, ORADEA);
		
		//BreadthFirst breadthFirst = new BreadthFirst(roumanie);
		
		//Set<Vertex> solution2 = breadthFirst.search(ARAD, BUCHAREST);
		
		//System.out.println(solution2);
		
		//UniformCost uniformCost = new UniformCost(roumanie);
		//System.out.println(uniformCost.search(ARAD, BUCHAREST));
	}
	
	
//	public static void showPath(Set<Node> solution) {
//		StringBuilder builder = new StringBuilder();
//		int totalCost = 0;
//		for(Node v: solution) {
//			builder.append(v.getId()+ " ");
//			totalCost += v.getCost();
//		}
//		builder.append("total cost: "+ totalCost);
//		System.out.println(builder.toString());
//	}
}