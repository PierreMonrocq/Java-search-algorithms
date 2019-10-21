package net.pierre.monrocq.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.pierre.monrocq.graphs.Edge;
import net.pierre.monrocq.graphs.Node;

public enum roumanie {//Modelisation des villes de la Roumanie
		ARAD, ZERIND, ORADEA, SIBIU, TIMISOARA, LUGOJ, MEHADIA,
				DROBETA, CRAIOVA, PITESTI, RIMNICU_VILCEA, FAGARAS, BUCHAREST,
				GIURGIU, URZICENI, EFORIE, VASLUI, IASI, NEAMT, HIRSOVA;
	
		private static final ArrayList<Edge> edges;
		private static ArrayList<String> labels = new ArrayList<String>();
		
		static {
			Edge[] _edges = new Edge[]{
					  new Edge(ARAD,ZERIND,75)
					 ,new Edge(ARAD,SIBIU,140)
					 ,new Edge(ARAD,TIMISOARA,118)
					 ,new Edge(TIMISOARA,LUGOJ,111)
					 ,new Edge(ZERIND,ORADEA,71)
					 ,new Edge(ORADEA,SIBIU,151)
					 ,new Edge(LUGOJ,MEHADIA,70)
					 ,new Edge(MEHADIA,DROBETA,75)
					 ,new Edge(DROBETA,CRAIOVA,120)
					 ,new Edge(CRAIOVA,RIMNICU_VILCEA,146)
					 ,new Edge(CRAIOVA,PITESTI,138)
					 ,new Edge(PITESTI,BUCHAREST,101)
					 ,new Edge(RIMNICU_VILCEA,SIBIU,80)
					 ,new Edge(SIBIU,FAGARAS,90)
					 ,new Edge(FAGARAS,BUCHAREST,211)
					 ,new Edge(BUCHAREST,GIURGIU,90)
					 ,new Edge(BUCHAREST,URZICENI,85)
					 ,new Edge(URZICENI,HIRSOVA,98)
					 ,new Edge(URZICENI,VASLUI,142)
					 ,new Edge(HIRSOVA,EFORIE,86)
					 ,new Edge(VASLUI,IASI,92)
					 ,new Edge(IASI,NEAMT,87)};
		
			edges = new ArrayList<Edge>();
			edges.addAll(Arrays.asList(_edges));
			for(roumanie r : roumanie.values()) {
				labels.add(r.name());
			}
			
		}
		
		public static ArrayList<Edge> getEdges() {
			return edges;
		}

		public static ArrayList<String> getLabels() {
			return labels;
		}
		

		
	
}
