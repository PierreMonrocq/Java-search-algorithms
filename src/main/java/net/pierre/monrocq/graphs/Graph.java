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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.EnumSet;



public class Graph implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Map<Vertex, List<Vertex>> adjacencyVertices;
	private Map<String, Integer> enumVariableIdentifier;

	public Graph() {//Create empty graph
		this.adjacencyVertices = new HashMap<Vertex, List<Vertex>>();
	}
	
	public Graph(int... labels) {//Create a graph directly with integers
		this.adjacencyVertices = new HashMap<Vertex, List<Vertex>>();
		for(int label : labels) {
			this.addVertex(new Vertex(label));
		}
	}
	
	public <E extends Enum<E>> Graph(Class<E> eClass) {//Create a graph with enums
		this.adjacencyVertices = new HashMap<Vertex, List<Vertex>>();
		this.enumVariableIdentifier = new HashMap<String, Integer>();
		Object[] list = EnumSet.allOf(eClass).toArray();
		for(int i=0;i<list.length;i++) {
			String label = list[i].toString();
			Vertex v = new Vertex(i,label);
			this.addVertex(v);
			this.enumVariableIdentifier.put(label, i);
		}
    }
	
	public void addVertex(Vertex vertex) {//Add a vertex object to the graph
		adjacencyVertices.putIfAbsent(vertex, new ArrayList<Vertex>());
	}
	
	public void addIdAsVertex(int id) {//Create an integer to the graph
		adjacencyVertices.putIfAbsent(new Vertex(id), new ArrayList<Vertex>());
	}
	
	public void removeVertex(int vertex) {
		Vertex v1 = new Vertex(vertex);
		adjacencyVertices.values().stream().forEach(e->e.remove(v1));
		adjacencyVertices.remove(new Vertex(vertex));
	}
	
	public void addEdge(int src, int dest, Integer... cost) {
		Vertex vertex1 = new Vertex(src);
		Vertex vertex2 = new Vertex(dest);
		if(cost.length != 0) {
			vertex1.setCost(cost[0]);
			vertex2.setCost(cost[0]);
		}
		adjacencyVertices.get(vertex1).add(vertex2);
		adjacencyVertices.get(vertex2).add(vertex1);
	}
	
	public void addOrientedEdge(int src, int dest, Integer... cost) {
		Vertex vertex1 = new Vertex(src);
		Vertex vertex2 = new Vertex(dest);
		if(cost.length != 0) {
			vertex1.setCost(cost[0]);
		}
		adjacencyVertices.get(vertex1).add(vertex2);
	}
	
	public <E extends Enum<E>> void addEdgeFromEnum(E e1, E e2, Integer... cost){
		int id1 = this.enumVariableIdentifier.get(e1.toString());
		int id2 = this.enumVariableIdentifier.get(e2.toString());
		Vertex vertex1 = new Vertex(id1);
		vertex1.setLabel(e1.toString());
		Vertex vertex2 = new Vertex(id2);
		vertex2.setLabel(e2.toString());
		if(cost.length != 0) {
			vertex1.setCost(cost[0]);
			vertex2.setCost(cost[0]);
		}
		adjacencyVertices.get(vertex1).add(vertex2);
		adjacencyVertices.get(vertex2).add(vertex1);
	}
	
	public void removeEdge(int label1, int label2) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		List<Vertex> edge1 = adjacencyVertices.get(vertex1);
		List<Vertex> edge2 = adjacencyVertices.get(vertex2);
		if(edge1 != null) {
			edge1.remove(vertex2);
		}
		if(edge2 != null) {
			edge2.remove(vertex1);
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
	
	public List<Vertex> getAdjacentVertices(int label){
		return adjacencyVertices.get(new Vertex(label));
	}
	
	@Override
	public String toString() {
		return adjacencyVertices.toString();
	}
	
}
