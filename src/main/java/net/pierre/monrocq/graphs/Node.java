package net.pierre.monrocq.graphs;

import java.io.Serializable;
import java.util.Comparator;

public class Node implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cost;
	private final String label;
	
	public Node(String label) {
		this.label = label;
		this.cost = -1;
	}
	
	public Node(String label,int cost) {
		this.label = label;
		this.cost = cost;
	}
	
	
	@Override //make 2 object with same label equal
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Node)) return false;
		if(obj == this) return true;
		return this.getLabel() == ((Node) obj).getLabel();
	}

	@Override //make 2 objects with same label have the same hashcode
	public int hashCode() {
		return label.hashCode();
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	@Override
	public String toString() {
		return this.cost != -1 ? this.label + " cost: " + this.cost : this.label;
		
	}
	
	public String getLabel() {
		return label;
	}
	
	Comparator<Node> vertexComparator = new Comparator<Node>() {
        @Override
        public int compare(Node v1, Node v2) {
            return v1.getCost() - v2.getCost();
        }
    };
	
	
}
