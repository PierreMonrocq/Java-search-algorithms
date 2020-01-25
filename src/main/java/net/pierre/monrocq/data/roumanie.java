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
		private static final ArrayList<Node> labels = new ArrayList<Node>();
		private static final HashMap<Node, Integer> flyDistanceToBucarest = new HashMap<Node, Integer>();
		
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
					 ,new Edge(RIMNICU_VILCEA,PITESTI,97)
					 ,new Edge(RIMNICU_VILCEA,SIBIU,80)
					 ,new Edge(SIBIU,FAGARAS,99)
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
				labels.add(new Node(r.name()));
			}
			
		}
		static {
			flyDistanceToBucarest.put(new Node(ARAD.name()), 366);
			flyDistanceToBucarest.put(new Node(BUCHAREST.name()), 0);
			flyDistanceToBucarest.put(new Node(CRAIOVA.name()), 160);
			flyDistanceToBucarest.put(new Node(DROBETA.name()), 242);
			flyDistanceToBucarest.put(new Node(EFORIE.name()), 161);
			flyDistanceToBucarest.put(new Node(FAGARAS.name()), 176);
			flyDistanceToBucarest.put(new Node(GIURGIU.name()), 77);
			flyDistanceToBucarest.put(new Node(HIRSOVA.name()), 151);
			flyDistanceToBucarest.put(new Node(IASI.name()), 226);
			flyDistanceToBucarest.put(new Node(LUGOJ.name()), 244);
			flyDistanceToBucarest.put(new Node(MEHADIA.name()), 241);
			flyDistanceToBucarest.put(new Node(NEAMT.name()), 234);
			flyDistanceToBucarest.put(new Node(ORADEA.name()), 380);
			flyDistanceToBucarest.put(new Node(PITESTI.name()), 100);
			flyDistanceToBucarest.put(new Node(RIMNICU_VILCEA.name()), 193);
			flyDistanceToBucarest.put(new Node(SIBIU.name()), 253);
			flyDistanceToBucarest.put(new Node(TIMISOARA.name()), 329);
			flyDistanceToBucarest.put(new Node(URZICENI.name()), 80);
			flyDistanceToBucarest.put(new Node(VASLUI.name()), 199);
			flyDistanceToBucarest.put(new Node(ZERIND.name()), 374);
		}
		
		public static HashMap<Node, Integer> getFlydistancetobucarest() {
			return flyDistanceToBucarest;
		}
		
		public static ArrayList<Edge> getEdges() {
			return edges;
		}

		public static ArrayList<Node> getLabels() {
			return labels;
		}
		

		
	
}
