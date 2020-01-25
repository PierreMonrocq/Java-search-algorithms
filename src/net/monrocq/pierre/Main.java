package net.monrocq.pierre;

import net.monrocq.pierre.graphs.Graph;

public class Main {
	
	public static void main(String[] args) {
		
		final int ARAD = 0, ZERIND = 1, ORADEA = 2, SIBIU = 3, TIMISOARA = 4, LUGOJ = 5,MEHADIA = 6,
				DROBETA = 7, CRAIOVA = 8, PITESTI = 9, RIMNICU_VILCEA = 10, FAGARAS =  11, BUCHAREST = 12,
						GIURGIU = 13, URZICENI = 14, EFORIE = 15,VASLUI = 16, IASI= 17, NEAMT = 18, HIRSOVA = 19;	
		
		//Modelisation de la Roumanie
		int[] vertices = {ARAD,ZERIND,ORADEA,
				SIBIU,TIMISOARA,LUGOJ,MEHADIA,DROBETA,CRAIOVA,PITESTI,
				RIMNICU_VILCEA,FAGARAS,BUCHAREST,GIURGIU,URZICENI,EFORIE,
				VASLUI,VASLUI,IASI,NEAMT,HIRSOVA};
		
		Graph graph = new Graph(vertices);
		
		graph.addEdgeWithCost(ARAD, SIBIU, 140);
		graph.addEdgeWithCost(ARAD, TIMISOARA, 118);
		graph.addEdgeWithCost(ARAD, ZERIND, 75);
		graph.addEdgeWithCost(SIBIU, ORADEA, 151);
		graph.addEdgeWithCost(ZERIND, ORADEA, 71);
		
		System.out.println(graph.getAdjacentVertices(ARAD));
	}
	
	
}
