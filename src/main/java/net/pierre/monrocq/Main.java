package net.pierre.monrocq;

import java.util.Set;

import net.pierre.monrocq.algorithms.BreadthFirst;
import net.pierre.monrocq.algorithms.DepthFirst;
import net.pierre.monrocq.graphs.Graph;
import net.pierre.monrocq.graphs.Vertex;

public class Main {
	
	public static final int ARAD = 0, ZERIND = 1, ORADEA = 2, SIBIU = 3, TIMISOARA = 4, LUGOJ = 5,MEHADIA = 6,
			DROBETA = 7, CRAIOVA = 8, PITESTI = 9, RIMNICU_VILCEA = 10, FAGARAS =  11, BUCHAREST = 12,
					GIURGIU = 13, URZICENI = 14, EFORIE = 15,VASLUI = 16, IASI= 17, NEAMT = 18, HIRSOVA = 19;	
	
	
	
	public static void main(String[] args) {
		

		Graph roumanie = Graph.load("roumanie.txt");
		
		//DepthFirst depthFirst = new DepthFirst(roumanie);
		
		//Set<Vertex> solution = depthFirst.search(ARAD, ORADEA);
		
		BreadthFirst breadthFirst = new BreadthFirst(roumanie);
		
		Set<Vertex> solution2 = breadthFirst.search(ARAD, BUCHAREST);
		
		System.out.println(solution2);
	}
	
	public static void showPath(Set<Vertex> solution) {
		StringBuilder builder = new StringBuilder();
		int totalCost = 0;
		for(Vertex v: solution) {
			builder.append(v.getId()+ " ");
			totalCost += v.getCost();
		}
		builder.append("total cost: "+ totalCost);
		System.out.println(builder.toString());
	}
}