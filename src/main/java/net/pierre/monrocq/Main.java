package net.pierre.monrocq;


import net.pierre.monrocq.graphs.Graph;

public class Main {
	
	public static final int ARAD = 0, ZERIND = 1, ORADEA = 2, SIBIU = 3, TIMISOARA = 4, LUGOJ = 5,MEHADIA = 6,
			DROBETA = 7, CRAIOVA = 8, PITESTI = 9, RIMNICU_VILCEA = 10, FAGARAS =  11, BUCHAREST = 12,
					GIURGIU = 13, URZICENI = 14, EFORIE = 15,VASLUI = 16, IASI= 17, NEAMT = 18, HIRSOVA = 19;	
	
	
	
	public static void main(String[] args) {
		
		//Modelisation de la Roumanie
		int[] vertices = {ARAD,ZERIND,ORADEA,
				SIBIU,TIMISOARA,LUGOJ,MEHADIA,DROBETA,CRAIOVA,PITESTI,
				RIMNICU_VILCEA,FAGARAS,BUCHAREST,GIURGIU,URZICENI,EFORIE,
				VASLUI,VASLUI,IASI,NEAMT,HIRSOVA};
		
		Graph graph = new Graph(vertices);
		
		graph.addEdge(ARAD, ZERIND, 75);
		graph.addEdge(ARAD, SIBIU, 140);
		graph.addEdge(ARAD, TIMISOARA, 118);
		graph.addEdge(ZERIND, ORADEA, 71);
		graph.addEdge(ORADEA, SIBIU, 151);
		graph.addEdge(TIMISOARA, LUGOJ, 111);
		graph.addEdge(LUGOJ, MEHADIA, 70);
		graph.addEdge(MEHADIA, DROBETA, 75);
		graph.addEdge(DROBETA, CRAIOVA, 120);
		graph.addEdge(CRAIOVA, RIMNICU_VILCEA, 146);
		graph.addEdge(RIMNICU_VILCEA, SIBIU, 80);
		graph.addEdge(SIBIU, FAGARAS, 99);
		graph.addEdge(FAGARAS, BUCHAREST, 211);
		graph.addEdge(RIMNICU_VILCEA, PITESTI, 97);
		graph.addEdge(PITESTI, CRAIOVA, 138);
		graph.addEdge(BUCHAREST, GIURGIU, 90);
		graph.addEdge(BUCHAREST, URZICENI, 85);
		graph.addEdge(URZICENI, HIRSOVA, 98);
		graph.addEdge(HIRSOVA, EFORIE, 86);
		graph.addEdge(URZICENI, VASLUI, 142);
		graph.addEdge(VASLUI, IASI, 92);
		graph.addEdge(IASI, NEAMT, 87);
		
		graph.save("roumanie.txt");
		
		System.out.println(graph);
	}
}