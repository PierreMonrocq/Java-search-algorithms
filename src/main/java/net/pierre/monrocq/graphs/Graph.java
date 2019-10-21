package net.pierre.monrocq.graphs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Graph implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Map<Node, List<Node>> adjacencyVertices;
	//private Map<String, Integer> enumVariableIdentifier;

	public Graph() {//Create empty graph
		this.adjacencyVertices = new HashMap<Node, List<Node>>();
	}
	
	public Graph(String... labels) {//Create a graph directly with integers
		this.adjacencyVertices = new HashMap<Node, List<Node>>();
		for(String label : labels) {
			this.addNode(label);
		}
	}
	
	public Graph(Node[] nodes, Edge[] edges) {
		this.adjacencyVertices = new HashMap<Node, List<Node>>();
		for(Node node : nodes) {
			this.addNode(node);
		}
		for(Edge e : edges) {
			addEdge(e.getSrc(), e.getDest(), e.getCost());
		}
	}
	
	public void addNode(String label) {
		adjacencyVertices.putIfAbsent(new Node(label), new ArrayList<Node>());
	}

	public void addNode(Node node) {//Add a node object to the graph
		adjacencyVertices.putIfAbsent(node, new ArrayList<Node>());
	}
	
	
	public void removeNode(String label) {
		Node v1 = new Node(label);
		adjacencyVertices.values().stream().forEach(e->e.remove(v1));
		adjacencyVertices.remove(new Node(label));
	}
	
	
	public <E extends Enum<E>> Graph(Class<E> eClass) {
		Object[] list = EnumSet.allOf(eClass).toArray();
		for(Object o : list) {
			String label = o.toString();
			Node n = new Node(label);
			this.addNode(n);
		}
		
	}
	
	public void addEdge(String src, String dest, Integer... cost) {
		Node vertex1 = new Node(src);
		Node vertex2 = new Node(dest);
		if(cost.length != 0) {
			vertex1.setCost(cost[0]);
			vertex2.setCost(cost[0]);
		}
		adjacencyVertices.get(vertex1).add(vertex2);
		adjacencyVertices.get(vertex2).add(vertex1);
	}
	
	public void addOrientedEdge(String src, String dest, Integer... cost) {
		Node vertex1 = new Node(src);
		Node vertex2 = new Node(dest);
		if(cost.length != 0) {
			vertex1.setCost(cost[0]);
		}
		adjacencyVertices.get(vertex1).add(vertex2);
	}
	
	
	public void addAllEdges(Edge[] edges) {
		for(Edge e : edges) {
			addEdge(e.getSrc(), e.getDest(), e.getCost());
		}
	}
	
	public void removeEdge(String label1, String label2) {
		Node node1 = new Node(label1);
		Node node2 = new Node(label2);
		List<Node> edge1 = adjacencyVertices.get(node1);
		List<Node> edge2 = adjacencyVertices.get(node2);
		if(edge1 != null) {
			edge1.remove(node2);
		}
		if(edge2 != null) {
			edge2.remove(node1);
		}	
	}
	
	public void save(String path) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			fileOutputStream.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}
	}
	
	public static Graph load(String path){
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(path));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			Graph graph = (Graph) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			
			return graph;
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Node> getAdjacentVertices(String label){
		return adjacencyVertices.get(new Node(label));
	}
	
	@Override
	public String toString() {
		return adjacencyVertices.toString();
	}
	
}
