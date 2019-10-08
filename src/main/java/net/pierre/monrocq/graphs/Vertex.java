package net.pierre.monrocq.graphs;

import java.io.Serializable;

public class Vertex implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;//this is the id, maybe later consider adding a "real" label
	private int cost;
	private String label;
	
	public Vertex(int id) {
		this.id = id;
		this.cost = -1;
		this.label = String.valueOf(id);
	}
	
	public Vertex(int id,int cost) {
		this.id = id;
		this.cost = cost;
		this.label = String.valueOf(id);
	}
	
	public Vertex(int id,int cost, String label) {
		this.id = id;
		this.cost = cost;
		this.label = label;
	}
	
	public Vertex(int id,String label) {
		this.id = id;
		this.cost = -1;
		this.label = label;
	}
	
	@Override //make 2 object with same label equal
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Vertex)) return false;
		if(obj == this) return true;
		return this.getId() == ((Vertex) obj).getId();
	}

	@Override //make 2 objects with same label have the same hashcode
	public int hashCode() {
		return id;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		if(this.label.length() != 0) {
			return this.cost != -1 ? this.label + " cost: " + this.cost : this.label;
		}
		return this.cost != -1 ? String.valueOf(id) + " cost: " + this.cost : String.valueOf(id);
		
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
