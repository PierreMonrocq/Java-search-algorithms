package net.pierre.monrocq;


import net.pierre.monrocq.graphs.Graph;

public class Main {
	
	public static final int ARAD = 0, ZERIND = 1, ORADEA = 2, SIBIU = 3, TIMISOARA = 4, LUGOJ = 5,MEHADIA = 6,
			DROBETA = 7, CRAIOVA = 8, PITESTI = 9, RIMNICU_VILCEA = 10, FAGARAS =  11, BUCHAREST = 12,
					GIURGIU = 13, URZICENI = 14, EFORIE = 15,VASLUI = 16, IASI= 17, NEAMT = 18, HIRSOVA = 19;	
	
	
	
	public static void main(String[] args) {
		

		Graph roumanie = Graph.load("roumanie.txt");
		
		System.out.println(roumanie.getAdjacentVertices(0));
	}
}